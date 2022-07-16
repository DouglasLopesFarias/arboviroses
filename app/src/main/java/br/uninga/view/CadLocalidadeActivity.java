package br.uninga.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.uninga.R;
import br.uninga.model.Localidade;
import br.uninga.repository.LocalidadeRepository;
import br.uninga.utils.TagForm;

public class CadLocalidadeActivity extends AppCompatActivity {

    Button btnSalvar;
    Button btnCancelar;
    EditText edtId;
    EditText edtDescricao;
    EditText edtCategoria;
    EditText edtZona;
    EditText edtExtrato;
    public static TagForm tagForm;
    public static Localidade localidade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_localidade);

        edtId         = findViewById(R.id.edtIdLocalidadeCad);
        edtDescricao  = findViewById(R.id.edtDescricaoLocalidadeCad);
        edtCategoria  = findViewById(R.id.edtCategoriaLocalidadeCad);
        edtZona       = findViewById(R.id.edtZonaLocalidadeCad);
        edtExtrato    = findViewById(R.id.edtExtratoLocalidadeCad);

        btnSalvar = findViewById(R.id.btnSalvarLocalidade);
        btnCancelar = findViewById(R.id.btnCancelarLocalidade);
        btnSalvar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.e("Id: ", edtId.getText().toString());
                Log.e("Descrição: ", edtDescricao.getText().toString());

                Localidade localidade = new Localidade();
                localidade.setId(edtId.getText().toString());
                localidade.setDescricao(edtDescricao.getText().toString());
                localidade.setCategoria(edtCategoria.getText().toString());
                localidade.setZona(edtZona.getText().toString());
                localidade.setExtrato(edtExtrato.getText().toString());

                LocalidadeRepository localidadeRepository = LocalidadeRepository.getInstance(CadLocalidadeActivity.this);
                if(tagForm == TagForm.I){
                    localidadeRepository.inserir(localidade);
                }else{
                    localidadeRepository.alterar(localidade);
                }
                finish();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadLocalidadeActivity.this, ListaLocalidadeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        if (tagForm == TagForm.A){
            preencheCampos();
        }
    }

    public void preencheCampos(){
        edtId.setText( String.valueOf(localidade.getId()));
        edtDescricao.setText(localidade.getDescricao());
        edtCategoria.setText(localidade.getCategoria());
        edtZona.setText(localidade.getZona());
        edtExtrato.setText(localidade.getExtrato());
    }
}