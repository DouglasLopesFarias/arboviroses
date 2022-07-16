package br.uninga.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.uninga.R;
import br.uninga.model.Bairro;
import br.uninga.repository.BairroRepository;
import br.uninga.utils.TagForm;

public class CadBairroActivity extends AppCompatActivity {


    Button btnSalvar;
    Button btnCancelar;
    EditText edtId;
    EditText edtDescricao;
    public static TagForm tagForm;
    public static Bairro bairro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_bairro);

        edtId         = findViewById(R.id.edtIdBairroCad);
        edtDescricao  = findViewById(R.id.edtDescricaoBairroCad);

        btnSalvar = findViewById(R.id.btnSalvarBairro);
        btnCancelar = findViewById(R.id.btnCancelarBairro);

        btnSalvar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.e("Id: ", edtId.getText().toString());
                Log.e("Descrição: ", edtDescricao.getText().toString());
                Bairro bairro = new Bairro();
                bairro.setId(edtId.getText().toString());
                bairro.setDescricao(edtDescricao.getText().toString());
                BairroRepository bairroRepository = BairroRepository.getInstance(CadBairroActivity.this);
                if(tagForm == TagForm.I){
                    bairroRepository.inserir(bairro);
                }else{
                    bairroRepository.alterar(bairro);
                }
                finish();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadBairroActivity.this, ListaBairroActivity.class);
                startActivity(intent);
                finish();
            }
        });

        if (tagForm == TagForm.A){
            preencheCampos();
        }

    }

    public void preencheCampos(){
        edtId.setText( String.valueOf(bairro.getId()));
        edtDescricao.setText(bairro.getDescricao());
    }
}