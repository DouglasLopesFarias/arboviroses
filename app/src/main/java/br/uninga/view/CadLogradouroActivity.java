package br.uninga.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.uninga.R;
import br.uninga.model.Bairro;
import br.uninga.model.Logradouro;
import br.uninga.repository.BairroRepository;
import br.uninga.repository.LogradouroRepository;
import br.uninga.utils.TagForm;

public class CadLogradouroActivity extends AppCompatActivity {

    Button btnSalvar;
    EditText edtId;
    EditText edtDescricao;
    public static TagForm tagForm;
    public static Logradouro logradouro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_logradouro);

        edtId         = findViewById(R.id.edtIdLogradouroCad);
        edtDescricao  = findViewById(R.id.edtDescricaoLogradouroCad);

        btnSalvar = findViewById(R.id.btnSalvarLogradouro);
        btnSalvar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.e("Id: ", edtId.getText().toString());
                Log.e("Descrição: ", edtDescricao.getText().toString());
                Logradouro logradouro = new Logradouro();
                logradouro.setId(edtId.getText().toString());
                logradouro.setDescricao(edtDescricao.getText().toString());
                LogradouroRepository logradouroRepository = LogradouroRepository.getInstance(CadLogradouroActivity.this);
                if(tagForm == TagForm.I){
                    logradouroRepository.inserir(logradouro);
                }else{
                    logradouroRepository.alterar(logradouro);
                }
                finish();
            }
        });

        if (tagForm == TagForm.A){
            preencheCampos();
        }
    }

    public void preencheCampos(){
        edtId.setText( String.valueOf(logradouro.getId()));
        edtDescricao.setText(logradouro.getDescricao());
    }
}