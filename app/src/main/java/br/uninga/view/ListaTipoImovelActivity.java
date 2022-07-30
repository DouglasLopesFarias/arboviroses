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
import br.uninga.adapters.BairroAdapter;
import br.uninga.adapters.TipoImovelAdapter;
import br.uninga.model.TipoDeImovel;
import br.uninga.repository.TipoDeImovelRepository;
import br.uninga.utils.TagForm;

public class ListaTipoImovelActivity extends AppCompatActivity {

    private FloatingActionButton fBtn_add8;;
    TipoDeImovelRepository tipoDeImovelRepository;
    ListView lvTipoImovel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tipo_imovel);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        tipoDeImovelRepository = TipoDeImovelRepository.getInstance(this);
        atualizaTela();

        lvTipoImovel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final TipoDeImovel tipoDeImovel = (TipoDeImovel)  parent.getItemAtPosition(position);

                AlertDialog alerta;
                AlertDialog.Builder builder = new AlertDialog.Builder(ListaTipoImovelActivity.this);
                builder.setTitle("Cadastro de Tipo de Imovel");
                builder.setMessage("Selecione uma opção!" );

                builder.setPositiveButton("Alterar".toString(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent = new Intent( ListaTipoImovelActivity.this, CadTipoImovelActivity.class);
                        CadTipoImovelActivity.tagForm = TagForm.A;
                        CadTipoImovelActivity.tipoDeImovel = tipoDeImovel;
                        startActivity(intent);
                        atualizaTela();
                    }
                });

                builder.setNeutralButton("Excluir".toString(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        tipoDeImovelRepository.remover(tipoDeImovel);
                        atualizaTela();
                    }
                });

                alerta = builder.create();
                alerta.show();
                atualizaTela();

            }
        });


        fBtn_add8 = findViewById(R.id.fBtn_add8);
        fBtn_add8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( ListaTipoImovelActivity.this, CadTipoImovelActivity.class);
                CadTipoImovelActivity.tagForm = TagForm.I;
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
        List<TipoDeImovel> tipoDeImovels = tipoDeImovelRepository.getAll();
        lvTipoImovel = findViewById(R.id.lvTipoImovel);
        ArrayAdapter ad = new TipoImovelAdapter(this,R.layout.lista_tipo_imovel,  tipoDeImovels);
        lvTipoImovel.setAdapter(ad);
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaTela();
    }
}