package br.uninga.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.uninga.R;
import br.uninga.model.Imovel;
import br.uninga.model.Localidade;
import br.uninga.repository.ImovelRepository;
import br.uninga.repository.LocalidadeRepository;
import br.uninga.utils.TagForm;

public class CadImovelActivity extends AppCompatActivity {

    Button btnSalvar;
    Button btnCancelar;
    EditText edtId;
    EditText edtLocalidade;
    EditText edtQuarteirao;
    EditText edtLogradouro;
    EditText edtNumero;
    EditText edtBairro;
    EditText edtTipoImovel;
    EditText edtComplemento;
    EditText edtSequencia;
    EditText edtTelefoneResidencial;
    EditText edtTelefoneRecado;
    EditText edtObservacao;

    public static TagForm tagForm;
    public static Imovel imovel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_imovel);

        edtId         = findViewById(R.id.edtIdImovelCad);
        edtLocalidade  = findViewById(R.id.edtLocalidadeImovelCad);
        edtQuarteirao  = findViewById(R.id.edtQuarteiraoImovelCad);
        edtLogradouro       = findViewById(R.id.edtLogradouroImovelCad);
        edtNumero    = findViewById(R.id.edtNumeroImovelCad);
        edtBairro    = findViewById(R.id.edtBairroImovelCad);
        edtTipoImovel    = findViewById(R.id.edtTipoImovelImovelCad);
        edtComplemento    = findViewById(R.id.edtComplementoImovelCad);
        edtSequencia    = findViewById(R.id.edtSequenciaImovelCad);
        edtTelefoneResidencial    = findViewById(R.id.edtTelefoneResidencialImovelCad);
        edtTelefoneRecado    = findViewById(R.id.edtTelefoneRecadoImovelCad);
        edtObservacao    = findViewById(R.id.edtObservacaoImovelCad);

        btnSalvar = findViewById(R.id.btnSalvarImovel);
        btnCancelar = findViewById(R.id.btnCancelarImovel);

        btnSalvar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Imovel imovel = new Imovel();
                imovel.setId(edtId.getText().toString());
                imovel.setLocalidade(edtLocalidade.getText().toString());
                imovel.setQuarteirao(edtQuarteirao.getText().toString());
                imovel.setLogradouro(edtLogradouro.getText().toString());
                imovel.setNumero(edtNumero.getText().toString());
                imovel.setBairro(edtBairro.getText().toString());
                imovel.setTipoImovel(edtTipoImovel.getText().toString());
                imovel.setComplemento(edtComplemento.getText().toString());
                imovel.setSequencia(edtSequencia.getText().toString());
                imovel.setTelefoneResidencial(edtTelefoneResidencial.getText().toString());
                imovel.setTelefoneRecado(edtTelefoneRecado.getText().toString());
                imovel.setObservacao(edtObservacao.getText().toString());

                ImovelRepository imovelRepository = ImovelRepository.getInstance(CadImovelActivity.this);
                if(tagForm == TagForm.I){
                    imovelRepository.inserir(imovel);
                }else{
                    imovelRepository.alterar(imovel);
                }
                finish();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadImovelActivity.this, ListaImovelActivity.class);
                startActivity(intent);
                finish();
            }
        });

        if (tagForm == TagForm.A){
            preencheCampos();
        }
    }

    public void preencheCampos(){

        edtId.setText(String.valueOf(imovel.getId()));
        edtLocalidade.setText(String.valueOf(imovel.getLocalidade()));
        edtQuarteirao.setText(String.valueOf(imovel.getQuarteirao()));
        edtLogradouro.setText(String.valueOf(imovel.getLogradouro()));
        edtNumero.setText(String.valueOf(imovel.getNumero()));
        edtBairro.setText(String.valueOf(imovel.getBairro()));
        edtTipoImovel.setText(String.valueOf(imovel.getTipoImovel()));
        edtComplemento.setText(String.valueOf(imovel.getComplemento()));
        edtSequencia.setText(String.valueOf(imovel.getSequencia()));
        edtTelefoneResidencial.setText(String.valueOf(imovel.getTelefoneResidencial()));
        edtTelefoneRecado.setText(String.valueOf(imovel.getTelefoneRecado()));
        edtObservacao.setText(String.valueOf(imovel.getObservacao()));

    }
}