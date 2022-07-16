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

import br.uninga.adapters.ImovelAdapter;
import br.uninga.model.Imovel;
import br.uninga.repository.ImovelRepository;

import br.uninga.utils.TagForm;

public class ListaImovelActivity extends AppCompatActivity {

    Button btnNovoImovel;
    ImovelRepository imovelRepository;
    ListView lvImovels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_imovel);

        imovelRepository = ImovelRepository.getInstance(this);
        atualizaTela();

        lvImovels.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Imovel imovel = (Imovel) parent.getItemAtPosition(position);

                AlertDialog alerta;
                AlertDialog.Builder builder = new AlertDialog.Builder(ListaImovelActivity.this);
                builder.setTitle("Cadastro de Imóvel");
                builder.setMessage("Selecione uma opção!" );

                builder.setPositiveButton("Alterar".toString(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent = new Intent( ListaImovelActivity.this, CadImovelActivity.class);
                        CadImovelActivity.tagForm = TagForm.A;
                        CadImovelActivity.imovel = imovel;
                        startActivity(intent);
                        atualizaTela();
                    }
                });

                builder.setNeutralButton("Excluir".toString(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        imovelRepository.remover(imovel);
                        atualizaTela();
                    }
                });

                alerta = builder.create();
                alerta.show();
                atualizaTela();

            }
        });


        btnNovoImovel = findViewById(R.id.btnNovoImovel);
        btnNovoImovel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( ListaImovelActivity.this, CadImovelActivity.class);
                CadImovelActivity.tagForm = TagForm.I;
                startActivity(intent);
            }
        });

    }

    public void atualizaTela(){
        List<Imovel> imovels = imovelRepository.getAll();
        lvImovels = findViewById(R.id.lvImovels);
        ArrayAdapter ad = new ImovelAdapter(this,R.layout.lista_imovel, imovels);
        lvImovels.setAdapter(ad);
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaTela();
    }
}