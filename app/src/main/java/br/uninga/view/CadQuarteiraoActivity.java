package br.uninga.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.uninga.R;

import br.uninga.model.Quarteirao;

import br.uninga.repository.QuarteiraoRepository;
import br.uninga.utils.TagForm;

public class CadQuarteiraoActivity extends AppCompatActivity {

    Button btnSalvar;
    Button btnCancelar;
    EditText edtId;
    EditText edtLocalidade;
    EditText edtNumero;
    EditText edtObservacao;
    public static TagForm tagForm;
    public static Quarteirao quarteirao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_quarteirao);

        edtId         = findViewById(R.id.edtIdQuarteiraoCad);
        edtLocalidade  = findViewById(R.id.edtLocalidadeQuarteiraoCad);
        edtNumero  = findViewById(R.id.edtNumeroQuarteiraoCad);
        edtObservacao       = findViewById(R.id.edtObservacaoQuarteiraoCad);

        btnSalvar = findViewById(R.id.btnSalvarQuarteirao);
        btnCancelar = findViewById(R.id.btnCancelarQuarteirao);
        btnSalvar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.e("Id: ", edtId.getText().toString());
                Log.e("Localidade: ", edtLocalidade.getText().toString());
                Log.e("numero: ", edtNumero.getText().toString());
                Log.e("observacao: ", edtObservacao.getText().toString());

                Quarteirao quarteirao = new Quarteirao();
                quarteirao.setId(edtId.getText().toString());
                quarteirao.setLocalidade(edtLocalidade.getText().toString());
                quarteirao.setNumero(edtNumero.getText().toString());
                quarteirao.setObservacao(edtObservacao.getText().toString());
                System.out.println("quarteirao" + quarteirao.getObservacao());

                QuarteiraoRepository quarteiraoRepository = QuarteiraoRepository.getInstance(CadQuarteiraoActivity.this);
                if(tagForm == TagForm.I){
                    quarteiraoRepository.inserir(quarteirao);
                }else{
                    quarteiraoRepository.alterar(quarteirao);
                }
                finish();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadQuarteiraoActivity.this, ListaQuarteiraoActivity.class);
                startActivity(intent);
                finish();
            }
        });

        if (tagForm == TagForm.A){
            preencheCampos();
        }
    }

    public void preencheCampos(){
        edtId.setText( String.valueOf(quarteirao.getId()));
        edtLocalidade.setText(quarteirao.getLocalidade());
        edtNumero.setText(quarteirao.getNumero());
        edtObservacao.setText(quarteirao.getObservacao());
    }
}