package br.uninga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.uninga.view.ListaBairroActivity;
import br.uninga.view.ListaImovelActivity;
import br.uninga.view.ListaLocalidadeActivity;
import br.uninga.view.ListaLogradouroActivity;
import br.uninga.view.ListaPNCDActivity;
import br.uninga.view.ListaQuarteiraoActivity;
import br.uninga.view.ListaQuarteiroesPNCD;
import br.uninga.view.ListaTipoImovelActivity;

public class MainActivity extends AppCompatActivity {

    Button btnBairro;
    Button btnLogradouro;
    Button btnLocalidade;
    Button btnQuarteirao;
    Button btnTipoImovel;
    Button btnImovel;
    Button btnQuarteiroesVisita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBairro = findViewById(R.id.btnBairro);
        btnBairro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, ListaBairroActivity.class);
                startActivity(intent);
            }
        });

        btnLogradouro = findViewById(R.id.btnLogradouro);
        btnLogradouro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, ListaLogradouroActivity.class);
                startActivity(intent);
            }
        });

        btnLocalidade = findViewById(R.id.btnLocalidade);
        btnLocalidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, ListaLocalidadeActivity.class);
                startActivity(intent);
            }
        });

        btnQuarteirao = findViewById(R.id.btnQuarteirao);
        btnQuarteirao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, ListaQuarteiraoActivity.class);
                startActivity(intent);
            }
        });

        btnTipoImovel = findViewById(R.id.btnTipoDeImovel);
        btnTipoImovel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, ListaTipoImovelActivity.class);
                startActivity(intent);
            }
        });

        btnImovel = findViewById(R.id.btnImovel);
        btnImovel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, ListaImovelActivity.class);
                startActivity(intent);
            }
        });

        btnQuarteiroesVisita = findViewById(R.id.btnPNCD);
        btnQuarteiroesVisita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, ListaQuarteiroesPNCD.class);
                startActivity(intent);
            }
        });

    }
}