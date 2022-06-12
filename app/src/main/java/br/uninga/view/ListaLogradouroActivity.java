package br.uninga.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import br.uninga.R;
import br.uninga.adapters.BairroAdapter;
import br.uninga.adapters.LogradouroAdapter;
import br.uninga.model.Bairro;
import br.uninga.model.Logradouro;
import br.uninga.repository.BairroRepository;
import br.uninga.repository.LogradouroRepository;
import br.uninga.utils.TagForm;

public class ListaLogradouroActivity extends AppCompatActivity {


    Button btnNovoLogradouro;
    LogradouroRepository logradouroRepository;
    ListView lvLogradouros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_logradouro);

        logradouroRepository = LogradouroRepository.getInstance(this);
        atualizaTela();

        lvLogradouros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Logradouro logradouro = (Logradouro) parent.getItemAtPosition(position);

                AlertDialog alerta;
                AlertDialog.Builder builder = new AlertDialog.Builder(ListaLogradouroActivity.this);
                builder.setTitle("Cadastro de Logradouro");
                builder.setMessage("Selecione uma opção!" );

                builder.setPositiveButton("Alterar".toString(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent = new Intent( ListaLogradouroActivity.this, CadLogradouroActivity.class);
                        CadLogradouroActivity.tagForm = TagForm.A;
                        CadLogradouroActivity.logradouro = logradouro;
                        startActivity(intent);
                        atualizaTela();
                    }
                });

                builder.setNeutralButton("Excluir".toString(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        logradouroRepository.remover(logradouro);
                        atualizaTela();
                    }
                });

                alerta = builder.create();
                alerta.show();
                atualizaTela();

            }
        });


        btnNovoLogradouro = findViewById(R.id.btnNovoLogradouro);
        btnNovoLogradouro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( ListaLogradouroActivity.this, CadLogradouroActivity.class);
                CadLogradouroActivity.tagForm = TagForm.I;
                startActivity(intent);
            }
        });

    }

    public void atualizaTela(){
        List<Logradouro> logradouros = logradouroRepository.getAll();
        lvLogradouros = findViewById(R.id.lvLogradouro);
        ArrayAdapter ad = new LogradouroAdapter(this,R.layout.lista_logradouro, logradouros);
        lvLogradouros.setAdapter(ad);
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaTela();
    }
}