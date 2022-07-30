package br.uninga.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import br.uninga.R;
import br.uninga.model.CadPNCD;
import br.uninga.repository.CadPNCDRepository;
import br.uninga.utils.Funcoes;
import br.uninga.utils.TagForm;


public class CadPNCDActivity extends AppCompatActivity {

    public static TagForm tagForm;
    public static CadPNCD cadPNCD;

    Button btnSalvar;
    Button btnCancelar;
    EditText edtId;
    EditText edtData;
    EditText edtHora;
    EditText edtA1;
    EditText edtA2;
    EditText edtB;
    EditText edtC;
    EditText edtD1;
    EditText edtD2;
    EditText edtE;
    EditText edtTipo01;
    EditText edtQuantidade01;
    EditText edtTipo02;
    EditText edtQuantidade02;
    EditText edtTipoDeImovel;
    EditText edtNumero;
    EditText edtComplemento;
    EditText edtSequencia;
    EditText edtNumeroDeMoradores;
    EditText edtTelefoneResidencial;
    EditText edtTelefoneRecado;
    EditText edtNomeMorador;
    EditText edtCpf;
    EditText edtDataNascimento;
    EditText edtNumerodoCartaoSus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_pncdactivity);
        btnSalvar = findViewById(R.id.btnSalvarPNCD);
        btnCancelar = findViewById(R.id.btnCancelarPNCD);

        edtId = findViewById(R.id.edtIdPNCDCad);
        edtData = findViewById(R.id.edtPNCDDataCad);
        edtHora = findViewById(R.id.edtPNCDHoraCad);
        edtA1 = findViewById(R.id.edtPNCDA1Cad);
        edtA2 = findViewById(R.id.edtPNCDA2Cad);
        edtB = findViewById(R.id.edtPNCDBCad);
        edtC = findViewById(R.id.edtPNCDCCad);
        edtD1 = findViewById(R.id.edtPNCDD1Cad);
        edtD2 = findViewById(R.id.edtPNCDD2Cad);
        edtE = findViewById(R.id.edtPNCDECad);
        edtTipo01 = findViewById(R.id.edtPNCDTipo01Cad);
        edtQuantidade01 = findViewById(R.id.edtPNCDQuantidade01Cad);
        edtTipo02 = findViewById(R.id.edtPNCDTipo02Cad);
        edtQuantidade02 = findViewById(R.id.edtPNCDQuantidade02Cad);
        edtTipoDeImovel = findViewById(R.id.edtPNCDTipoDeImovelCad);
        edtNumero = findViewById(R.id.edtPNCDNumeroCad);
        edtComplemento = findViewById(R.id.edtPNCDComplementoCad);
        edtSequencia = findViewById(R.id.edtPNCDSequenciaCad);
        edtNumeroDeMoradores = findViewById(R.id.edtPNCDNumeroDeMoradoresCad);
        edtTelefoneResidencial = findViewById(R.id.edtPNCDTelefoneResidencialCad);
        edtTelefoneRecado = findViewById(R.id.edtPNCDTelefoneRecadoCad);
        edtNomeMorador = findViewById(R.id.edtPNCDNomeMoradorCad);
        edtCpf = findViewById(R.id.edtPNCDCPFCad);
        edtDataNascimento = findViewById(R.id.edtPNCDDataNascimentoCad);
        edtNumerodoCartaoSus = findViewById(R.id.edtPNCDNumerodoCartaoSusCad);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CadPNCD cadPNCD = new CadPNCD();
                cadPNCD.setId(edtId.getText().toString());
                cadPNCD.setData(edtData.getText().toString());
                cadPNCD.setHora(edtHora.getText().toString());
                cadPNCD.setA1(edtA1.getText().toString());
                cadPNCD.setA2(edtA2.getText().toString());
                cadPNCD.setB(edtB.getText().toString());
                cadPNCD.setC(edtC.getText().toString());
                cadPNCD.setD1(edtD1.getText().toString());
                cadPNCD.setD2(edtD2.getText().toString());
                cadPNCD.setE(edtE.getText().toString());
                cadPNCD.setTipo01(edtTipo01.getText().toString());
                cadPNCD.setQuantidade01(edtQuantidade01.getText().toString());
                cadPNCD.setTipo02(edtTipo02.getText().toString());
                cadPNCD.setQuantidade02(edtQuantidade02.getText().toString());
                cadPNCD.setTipodeImovel(edtTipoDeImovel.getText().toString());
                cadPNCD.setNumero(edtNumero.getText().toString());
                cadPNCD.setComplemento(edtComplemento.getText().toString());
                cadPNCD.setSequencia(edtSequencia.getText().toString());
                cadPNCD.setNumerodeMoradores(edtNumeroDeMoradores.getText().toString());
                cadPNCD.setTelefoneResidencial(edtTelefoneResidencial.getText().toString());
                cadPNCD.setTelefoneRecado(edtTelefoneRecado.getText().toString());
                cadPNCD.setNomeMorador(edtNomeMorador.getText().toString());
                cadPNCD.setCpf(edtCpf.getText().toString());
                cadPNCD.setDataNascimento(edtDataNascimento.getText().toString());
                cadPNCD.setNumerodoCartaoSus(edtNumerodoCartaoSus.getText().toString());

                CadPNCDRepository cadPNCDRepository = CadPNCDRepository.getInstance(CadPNCDActivity.this);
                if (tagForm == TagForm.I) {
                    cadPNCD.setId(Funcoes.getUUID());
                    cadPNCDRepository.inserir(cadPNCD);
                } else {
                    cadPNCDRepository.alterar(cadPNCD);
                }
                finish();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadPNCDActivity.this, ListaPNCDActivity.class);
                startActivity(intent);
                finish();
            }
        });

        if (tagForm == TagForm.A) {
            preencheCampos();
        }
    }

    public void preencheCampos() {

        edtId.setText(String.valueOf(cadPNCD.getId()));
        edtData.setText(String.valueOf(cadPNCD.getData()));
        edtHora.setText(String.valueOf(cadPNCD.getHora()));
        edtA1.setText(String.valueOf(cadPNCD.getA1()));
        edtA2.setText(String.valueOf(cadPNCD.getA2()));
        edtB.setText(String.valueOf(cadPNCD.getB()));
        edtC.setText(String.valueOf(cadPNCD.getC()));
        edtD1.setText(String.valueOf(cadPNCD.getD1()));
        edtD2.setText(String.valueOf(cadPNCD.getD2()));
        edtE.setText(String.valueOf(cadPNCD.getE()));
        edtTipo01.setText(String.valueOf(cadPNCD.getTipo01()));
        edtQuantidade01.setText(String.valueOf(cadPNCD.getQuantidade01()));
        edtTipo02.setText(String.valueOf(cadPNCD.getTipo02()));
        edtQuantidade02.setText(String.valueOf(cadPNCD.getQuantidade02()));
        edtTipoDeImovel.setText(String.valueOf(cadPNCD.getTipodeImovel()));
        edtNumero.setText(String.valueOf(cadPNCD.getNumero()));
        edtComplemento.setText(String.valueOf(cadPNCD.getComplemento()));
        edtSequencia.setText(String.valueOf(cadPNCD.getSequencia()));
        edtNumeroDeMoradores.setText(String.valueOf(cadPNCD.getNumerodeMoradores()));
        edtTelefoneResidencial.setText(String.valueOf(cadPNCD.getTelefoneResidencial()));
        edtTelefoneRecado.setText(String.valueOf(cadPNCD.getTelefoneRecado()));
        edtNomeMorador.setText(String.valueOf(cadPNCD.getNomeMorador()));
        edtCpf.setText(String.valueOf(cadPNCD.getCpf()));
        edtDataNascimento.setText(String.valueOf(cadPNCD.getDataNascimento()));
        edtNumerodoCartaoSus.setText(String.valueOf(cadPNCD.getNumerodoCartaoSus()));

    }
}