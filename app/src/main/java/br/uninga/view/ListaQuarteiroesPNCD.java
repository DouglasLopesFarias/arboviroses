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
import br.uninga.adapters.QuarteiroesVistoriaAdapter;
import br.uninga.model.Bairro;
import br.uninga.model.QuarteiroesVistoria;
import br.uninga.repository.BairroRepository;
import br.uninga.repository.QuarteiroesVistoriaRepository;
import br.uninga.utils.TagForm;

public class ListaQuarteiroesPNCD extends AppCompatActivity {


    QuarteiroesVistoriaRepository quarteiroesVistoriaRepository;
    ListView lvQuarteiroesVistoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(br.uninga.R.layout.activity_lista_quarteiroes_pncd);

        quarteiroesVistoriaRepository = QuarteiroesVistoriaRepository.getInstance(this);
        atualizaTela();

        lvQuarteiroesVistoria.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final QuarteiroesVistoria quarteiroesVistoria = (QuarteiroesVistoria)  parent.getItemAtPosition(position);

                AlertDialog alerta;
                AlertDialog.Builder builder = new AlertDialog.Builder(ListaQuarteiroesPNCD.this);
                builder.setTitle("Quarteiroes para vistoria");
                builder.setMessage("Selecione uma opção!" );

                builder.setPositiveButton("Abrir lista de imoveis".toString(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        //Intent intent = new Intent( ListaQuarteiroesPNCD.this, CadBairroActivity.class);
                        //CadBairroActivity.tagForm = TagForm.A;
                        //CadBairroActivity.bairro = bairro;
                        //startActivity(intent);
                        atualizaTela();
                    }
                });

                builder.setNeutralButton("Excluir".toString(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        quarteiroesVistoriaRepository.remover(quarteiroesVistoria);
                        atualizaTela();
                    }
                });

                alerta = builder.create();
                alerta.show();
                atualizaTela();

            }
        });

    }

    public void atualizaTela(){
        List<QuarteiroesVistoria>  quarteiroesVistoriaList = quarteiroesVistoriaRepository.getAll();
        lvQuarteiroesVistoria = findViewById(R.id.lvQuarteiroesVisita);
        ArrayAdapter ad = new QuarteiroesVistoriaAdapter(this,R.layout.lista_quarteiroes_vistoria, quarteiroesVistoriaList);
        lvQuarteiroesVistoria.setAdapter(ad);
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaTela();
    }
}