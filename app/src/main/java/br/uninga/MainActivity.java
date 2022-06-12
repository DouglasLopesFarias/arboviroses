package br.uninga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.uninga.view.ListaBairroActivity;
import br.uninga.view.ListaLogradouroActivity;

public class MainActivity extends AppCompatActivity {

    Button btnBairro;
    Button btnLogradouro;
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

    }
}