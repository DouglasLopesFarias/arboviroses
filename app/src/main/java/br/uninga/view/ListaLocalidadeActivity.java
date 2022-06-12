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
import br.uninga.adapters.LocalidadeAdapter;
import br.uninga.adapters.LogradouroAdapter;
import br.uninga.model.Localidade;
import br.uninga.repository.LocalidadeRepository;
import br.uninga.utils.TagForm;

public class ListaLocalidadeActivity extends AppCompatActivity {

    Button btnNovoLocalidade;
    LocalidadeRepository localidadeRepository;
    ListView lvLocalidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_localidade);

        localidadeRepository = LocalidadeRepository.getInstance(this);
        atualizaTela();

        lvLocalidades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Localidade localidade = (Localidade) parent.getItemAtPosition(position);

                AlertDialog alerta;
                AlertDialog.Builder builder = new AlertDialog.Builder(ListaLocalidadeActivity.this);
                builder.setTitle("Cadastro de Localidades");
                builder.setMessage("Selecione uma opção!" );

                builder.setPositiveButton("Alterar".toString(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent = new Intent( ListaLocalidadeActivity.this, CadLocalidadeActivity.class);
                        CadLocalidadeActivity.tagForm = TagForm.A;
                        CadLocalidadeActivity.localidade = localidade;
                        startActivity(intent);
                        atualizaTela();
                    }
                });

                builder.setNeutralButton("Excluir".toString(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        localidadeRepository.remover(localidade);
                        atualizaTela();
                    }
                });

                alerta = builder.create();
                alerta.show();
                atualizaTela();

            }
        });


        btnNovoLocalidade = findViewById(R.id.btnNovoLocalidade);
        btnNovoLocalidade.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( ListaLocalidadeActivity.this, CadLocalidadeActivity.class);
                CadLocalidadeActivity.tagForm = TagForm.I;
                startActivity(intent);
            }
        });

    }


    public void atualizaTela(){
        List<Localidade> localidades = localidadeRepository.getAll();
        lvLocalidades = findViewById(R.id.lvLocalidades);
        ArrayAdapter ad = new LocalidadeAdapter(this,R.layout.lista_localidades, localidades);
        lvLocalidades.setAdapter(ad);
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaTela();
    }
}