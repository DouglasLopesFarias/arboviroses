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


import br.uninga.adapters.QuarteiraoAdapter;
import br.uninga.model.Quarteirao;
import br.uninga.repository.QuarteiraoRepository;
import br.uninga.utils.TagForm;

public class ListaQuarteiraoActivity extends AppCompatActivity {

    Button btnNovoQuarteirao;
    QuarteiraoRepository quarteiraoRepository;
    ListView lvQuarteirao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_quarteirao);

        quarteiraoRepository = QuarteiraoRepository.getInstance(this);
        atualizaTela();

        lvQuarteirao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Quarteirao quarteirao = (Quarteirao) parent.getItemAtPosition(position);

                AlertDialog alerta;
                AlertDialog.Builder builder = new AlertDialog.Builder(ListaQuarteiraoActivity.this);
                builder.setTitle("Cadastro de Quarteirão");
                builder.setMessage("Selecione uma opção!" );

                builder.setPositiveButton("Alterar".toString(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent = new Intent( ListaQuarteiraoActivity.this, CadQuarteiraoActivity.class);
                        CadQuarteiraoActivity.tagForm = TagForm.A;
                        CadQuarteiraoActivity.quarteirao = quarteirao;
                        startActivity(intent);
                        atualizaTela();
                    }
                });

                builder.setNeutralButton("Excluir".toString(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        quarteiraoRepository.remover(quarteirao);
                        atualizaTela();
                    }
                });

                alerta = builder.create();
                alerta.show();
                atualizaTela();

            }
        });

        btnNovoQuarteirao = findViewById(R.id.btnNovoQuarteirao);
        btnNovoQuarteirao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( ListaQuarteiraoActivity.this, CadQuarteiraoActivity.class);
                CadQuarteiraoActivity.tagForm = TagForm.I;
                startActivity(intent);
            }
        });

    }

    public void atualizaTela(){
        List<Quarteirao> quarteiraos = quarteiraoRepository.getAll();
        lvQuarteirao = findViewById(R.id.lvQuarteirao);
        ArrayAdapter ad = new QuarteiraoAdapter(this,R.layout.lista_quarteirao, quarteiraos);
        lvQuarteirao.setAdapter(ad);
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaTela();
    }
}