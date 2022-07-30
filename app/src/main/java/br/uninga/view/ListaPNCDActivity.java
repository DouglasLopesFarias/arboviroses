package br.uninga.view;

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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import br.uninga.R;
import br.uninga.adapters.PNCDListaImovelAdapter;
import br.uninga.model.CadPNCD;
import br.uninga.repository.CadPNCDRepository;
import br.uninga.utils.TagForm;

public class ListaPNCDActivity extends AppCompatActivity {

    private FloatingActionButton fBtn_add5;
    CadPNCDRepository cadPNCDRepository;
    ListView lvPNCDList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pncdactivity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        cadPNCDRepository = CadPNCDRepository.getInstance(this);
        atualizaTela();

        lvPNCDList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final CadPNCD cadPNCD = (CadPNCD) parent.getItemAtPosition(position);

                AlertDialog alerta;
                AlertDialog.Builder builder = new AlertDialog.Builder(ListaPNCDActivity.this);
                builder.setTitle("Cadastro de vistoria");
                builder.setMessage("Selecione uma opção!" );

                builder.setPositiveButton("Vistoriar".toString(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent = new Intent( ListaPNCDActivity.this, CadPNCDActivity.class);
                        CadPNCDActivity.tagForm = TagForm.A;
                        CadPNCDActivity.cadPNCD = cadPNCD;
                        startActivity(intent);
                        atualizaTela();
                    }
                });

                builder.setNeutralButton("Excluir".toString(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        cadPNCDRepository.remover(cadPNCD);
                        atualizaTela();
                    }
                });

                alerta = builder.create();
                alerta.show();
                atualizaTela();

            }
        });

        fBtn_add5 = findViewById(R.id.fBtn_add5);
        fBtn_add5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( ListaPNCDActivity.this, CadPNCDActivity.class);
                CadPNCDActivity.tagForm = TagForm.I;
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
        List<CadPNCD> cadPNCDS = cadPNCDRepository.getAll();
        lvPNCDList = findViewById(R.id.lvPNCD);
        ArrayAdapter ad = new PNCDListaImovelAdapter(this, R.layout.lista_pncd, cadPNCDS);
        lvPNCDList.setAdapter(ad);
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaTela();
    }
}