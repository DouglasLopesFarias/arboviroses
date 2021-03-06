package br.uninga.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "arboviroses";
    public static final String TBL_AGENTE = "agente";
    public static final String TBL_BAIRRO = "bairro";
    public static final String TBL_LOGRADOURO = "logradouro";
    public static final String TBL_LOCALIDADE = "localidade";
    public static final String TBL_QUARTEIRAO = "quarteirao";
    public static final String TBL_TIPO_DE_IMOVEL = "tipo_imovel";
    public static final String TBL_IMOVEL = "imovel";
    public static final String TBL_QUARTEIROES_VISTORIAS ="quarteiroes_vistoria";
    public static final String TBL_TELACAD_PNCD = "TelaCadPNCD";


    public static final String SCRIPT_TBL_AGENTE  = " create table agente("+
            " id string not null primary key, "+
            " email text, "+
            " senha text, "+
            " nome text not null);";

    public static final String SCRIPT_TBL_BAIRRO = " create table bairro("+
            " id string not null primary key, "+
            " descricao text not null);";

    public static final String SCRIPT_TBL_LOGRADOURO = " create table logradouro("+
            " id string not null primary key, "+
            " descricao text not null);";

    public static final String SCRIPT_TBL_LOCALIDADE = " create table localidade("+
            " id string not null primary key, "+
            " descricao text, "+
            " categoria text, "+
            " zona text, "+
            " extrato text not null);";

    public static final String SCRIPT_TBL_QUARTEIRAO = " create table quarteirao("+
            " id string not null primary key, "+
            " localidade text, "+
            " numero text, "+
            " observacao text not null);";

    public static final String SCRIPT_TBL_TIPO_DE_IMOVEL = " create table tipo_imovel("+
            " id string not null primary key, "+
            " sigla text, "+
            " descricao text not null);";

    public static final String SCRIPT_TBL_IMOVEL = " create table imovel("+
            " id string not null primary key, "+
            " localidade text, "+
            " quarteirao text, "+
            " logradouro text, "+
            " numero text, "+
            " bairro text, "+
            " tipoImovel text, "+
            " complemento text, "+
            " sequencia text, "+
            " telefoneResidencial text, "+
            " telefoneRecado text, "+
            " observacao text not null);";

    public static final String SCRIPT_TBL_QUARTEIROES_VISTORIA = " create table quarteiroes_vistoria("+
            " id string not null primary key, "+
            " localidade text, "+
            " numero text, "+
            " id_agente text, "+
            " id_quarteirao text, "+
            " observacao text not null);";

    public static final String SCRIPT_TBL_TELACAD_PNCD = " create table TelaCadPNCD(" +
            " id string not null primary key, " +
            " data text, " +
            " hora text, " +
            " a1 text, " +
            " a2 text, " +
            " b text, " +
            " c text, " +
            " d1 text, " +
            " d2 text, " +
            " e text, " +
            " tipo01 text, " +
            " quantidade01 text, " +
            " tipo02 text, " +
            " quantidade02 text, " +
            " tipodeImovel text, " +
            " numero text, " +
            " complemento text, " +
            " sequencia text, " +
            " numerodeMoradores text, " +
            " telefoneResidencial text, " +
            " telefoneRecado text, " +
            " nomeMorador text, " +
            " cpf text, " +
            " dataNascimento text, " +
            " numerodoCartaoSus text not null);";


    public static final String SCRIPT_POPULA_BASE1 = new StringBuilder().append(" ").
            append(" insert into quarteiroes_vistoria(id, localidade, numero, id_agente, id_quarteirao, observacao) ").
            append(" values('010101', 'localidade 01', '100A', '0101', '0101', 'quarteirao teste 01 '); ").toString();


    public static final String SCRIPT_POPULA_BASE2 = new StringBuilder().append(" ").
            append(" insert into quarteiroes_vistoria(id, localidade, numero, id_agente, id_quarteirao, observacao) ").
            append(" values( '010102', 'localidade 02', '200A', '0202', '0202', 'quarteirao teste 02 ' ); ").toString();


    public static final String SCRIPT_POPULA_BASE3 = new StringBuilder().append(" ").
            append(" insert into quarteiroes_vistoria(id, localidade, numero, id_agente, id_quarteirao, observacao) ").
            append(" values( '010103', 'localidade 03', '300A', '0303', '0303', 'quarteirao teste 03 ' ); ").toString();


    public static final String SCRIPT_POPULA_BASE_AGENTE1 = new StringBuilder().append(" ").
            append(" insert into agente(id, email,senha, nome) ").
            append(" values( '010101', 'agente01@sesa.br', '123','agente 01' ); ").toString();

    public static final String SCRIPT_POPULA_BASE_AGENTE2 = new StringBuilder().append(" ").
            append(" insert into agente(id, email,senha, nome) ").
            append(" values( '010102', 'agente02@sesa.br', '123','agente 02' ); ").toString();

    public static final String SCRIPT_POPULA_BASE_AGENTE3 = new StringBuilder().append(" ").
            append(" insert into agente(id, email, senha, nome) ").
            append(" values( '010103', 'agente03@sesa.br', '123', 'agente 03' ); ").toString();


    public DB(Context context){
        super(context, NOME_BANCO, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SCRIPT_TBL_AGENTE);
        db.execSQL(SCRIPT_TBL_BAIRRO);
        db.execSQL(SCRIPT_TBL_LOGRADOURO);
        db.execSQL(SCRIPT_TBL_LOCALIDADE);
        db.execSQL(SCRIPT_TBL_QUARTEIRAO);
        db.execSQL(SCRIPT_TBL_TIPO_DE_IMOVEL);
        db.execSQL(SCRIPT_TBL_IMOVEL);
        db.execSQL(SCRIPT_TBL_QUARTEIROES_VISTORIA);
        db.execSQL(SCRIPT_POPULA_BASE1);
        db.execSQL(SCRIPT_POPULA_BASE2);
        db.execSQL(SCRIPT_POPULA_BASE3);
        db.execSQL(SCRIPT_POPULA_BASE_AGENTE1);
        db.execSQL(SCRIPT_POPULA_BASE_AGENTE2);
        db.execSQL(SCRIPT_POPULA_BASE_AGENTE3);
        db.execSQL(SCRIPT_TBL_TELACAD_PNCD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
