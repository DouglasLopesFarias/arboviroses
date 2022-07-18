package br.uninga;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.uninga.model.Agente;
import br.uninga.repository.AgenteRepository;
import br.uninga.repository.BairroRepository;
import br.uninga.view.CadBairroActivity;
import br.uninga.view.ListaBairroActivity;
import br.uninga.view.ListaQuarteiroesPNCD;

public class LoginActivity extends AppCompatActivity {


    Button btnLogar;
    EditText edtLogin;
    EditText edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogar = findViewById(R.id.btnLogar);
        btnLogar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AgenteRepository agenteRepository = AgenteRepository.getInstance(LoginActivity.this);
                edtLogin         = findViewById(R.id.edtLogin);
                edtSenha         = findViewById(R.id.edtSenha);

                /*Agente agente = new Agente();
                agente.setEmail(edtLogin.getText().toString());
                agente.setSenha(edtSenha.getText().toString());
                if ( agenteRepository.buscarLogin(agente) == true){
                    Intent intent = new Intent( LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    AlertDialog alerta;
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setTitle("Login inválido");
                    builder.setMessage("Digite um login válido!" );
                    builder.setPositiveButton("OK".toString(), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {

                        }
                    });
                    alerta = builder.create();
                    alerta.show();
                }*/

                Intent intent = new Intent( LoginActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}