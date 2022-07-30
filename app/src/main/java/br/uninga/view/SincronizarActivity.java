package br.uninga.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.NameValuePair;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.ClientProtocolException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.HttpClient;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.entity.UrlEncodedFormEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpPost;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client.DefaultHttpClient;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import br.uninga.R;
import br.uninga.model.CadPNCD;
import br.uninga.repository.CadPNCDRepository;
import br.uninga.service.ServicePNCD;
import br.uninga.utils.Conexao;
import br.uninga.utils.DadosSincronizados;
import br.uninga.utils.PncdAsync;
import br.uninga.utils.TagForm;
import okhttp3.Response;
import retrofit2.Call;

public class SincronizarActivity extends AppCompatActivity {


    private Button btnSincronizarGet;
    private TextView txtSincronizarGet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sincronizar);

        btnSincronizarGet = findViewById(R.id.btnSincronizarGet);
        txtSincronizarGet = findViewById(R.id.txtSincronizarGet);

        btnSincronizarGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //== envia dados
                CadPNCDRepository cadPNCDRepository = CadPNCDRepository.getInstance(SincronizarActivity.this);
                List<CadPNCD> lista = cadPNCDRepository.getAll();
                for (CadPNCD obj: lista) {
                    Gson gson = new Gson();
                    String json = gson.toJson(obj);

                    TarefaEnvio tarefaEnvio = new TarefaEnvio();
                    tarefaEnvio.execute(json);
                }

                //== baixa dados
                Tarefa tarefa = new Tarefa();
                tarefa.execute("http://192.168.0.2:8001/api/v1/pncd");
            }
        });


    }

    private class Tarefa extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... strings){
            String retorno = Conexao.getDados(strings[0]);
            DadosSincronizados dadosSincronizados = PncdAsync.sincronizarPNCD(retorno);
            List<CadPNCD> lista = dadosSincronizados.getLista();
            CadPNCDRepository cadPNCDRepository = CadPNCDRepository.getInstance(SincronizarActivity.this);
            for (CadPNCD obj: lista) {
                cadPNCDRepository.salvar(obj);
            }
            return "Total sincronizados: " +dadosSincronizados.getTotalSincronizados() + "\n"+
                    " Total Erros: " + dadosSincronizados.getTotalErros();
        }

        @Override
        protected void onPostExecute(String s) {
            txtSincronizarGet.setText(s);
        }
    }


    private class TarefaEnvio extends AsyncTask<String, String, String>{
        @SuppressLint("ResourceType")
        @Override
        protected String doInBackground(String... params){

            String urlString = "http://192.168.0.2:8001/api/v1/pncd";
            String data = params[0]; //data to post
            OutputStream out = null;
            Context context = null;
            String response = "";

            try {
                URL url = new URL(urlString);

                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                //out = new BufferedOutputStream(urlConnection.getOutputStream());
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                //conn.setReadTimeout(context.getResources().getInteger(100));
                //conn.setConnectTimeout(context.getResources().getInteger(100));
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setRequestProperty("Content-Type", "application/json");

                String str = data.toString();
                byte[] outputBytes = str.getBytes("UTF-8");
                OutputStream os = conn.getOutputStream();
                os.write(outputBytes);

                int responseCode = conn.getResponseCode();


                if (responseCode == HttpsURLConnection.HTTP_OK) {
                    String line;
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    while ((line = br.readLine()) != null) {
                        response += line;
                    }
                } else {

                    response = "";
                }


                /*BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
                writer.write(data);
                writer.flush();
                writer.close();
                out.close();*/

                urlConnection.connect();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            return "OK";
        }

        @Override
        protected void onPostExecute(String s) {

        }
    }




}