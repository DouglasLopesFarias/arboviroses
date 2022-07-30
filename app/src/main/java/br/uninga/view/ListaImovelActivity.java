package br.uninga.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import br.uninga.R;

import br.uninga.adapters.ImovelAdapter;
import br.uninga.model.Imovel;
import br.uninga.repository.ImovelRepository;

import br.uninga.utils.TagForm;

public class ListaImovelActivity extends AppCompatActivity {

    private FloatingActionButton fBtn_add2;
    ImovelRepository imovelRepository;
    ListView lvImovels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_imovel);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

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


        fBtn_add2 = findViewById(R.id.fBtn_add2);
        fBtn_add2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( ListaImovelActivity.this, CadImovelActivity.class);
                CadImovelActivity.tagForm = TagForm.I;
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//inflate do menu
        getMenuInflater().inflate(R.menu.pesquisar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//infate item pesquisar

        if (item.getItemId() == R.id.btnMenu_Busca) {
            return true;
        }
        return super.onOptionsItemSelected(item);
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