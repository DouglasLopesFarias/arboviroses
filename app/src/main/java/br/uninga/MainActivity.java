package br.uninga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.uninga.view.ListaBairroActivity;

public class MainActivity extends AppCompatActivity {

    Button btnBairro;
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

    }
}