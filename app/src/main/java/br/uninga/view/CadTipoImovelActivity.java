package br.uninga.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import br.uninga.R;
import br.uninga.model.TipoDeImovel;
import br.uninga.repository.TipoDeImovelRepository;
import br.uninga.utils.TagForm;

public class CadTipoImovelActivity extends AppCompatActivity {

    Button btnSalvar;
    EditText edtId;
    EditText edtSigla;
    EditText edtDescricao;
    public static TagForm tagForm;
    public static TipoDeImovel tipoDeImovel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_tipo_imovel);

        edtId         = findViewById(R.id.edtIdTipoImovelCad);
        edtSigla  = findViewById(R.id.edtSiglaTipoImovelCad);
        edtDescricao  = findViewById(R.id.edtDescricaoTipoImovelCad);


        btnSalvar = findViewById(R.id.btnSalvarTipoImovel);
        btnSalvar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.e("Id: ", edtId.getText().toString());
                Log.e("Descrição: ", edtDescricao.getText().toString());
                TipoDeImovel tipoDeImovel = new TipoDeImovel();
                tipoDeImovel.setId(edtId.getText().toString());
                tipoDeImovel.setSigla(edtSigla.getText().toString());
                tipoDeImovel.setDescricao(edtDescricao.getText().toString());
                TipoDeImovelRepository tipoDeImovelRepository = TipoDeImovelRepository.getInstance(CadTipoImovelActivity.this);
                if(tagForm == TagForm.I){
                    tipoDeImovelRepository.inserir(tipoDeImovel);
                }else{
                    tipoDeImovelRepository.alterar(tipoDeImovel);
                }
                finish();
            }
        });

        if (tagForm == TagForm.A){
            preencheCampos();
        }
    }

    public void preencheCampos(){
        edtId.setText( String.valueOf(tipoDeImovel.getId()));
        edtSigla.setText(tipoDeImovel.getSigla());
        edtDescricao.setText(tipoDeImovel.getDescricao());
    }
}