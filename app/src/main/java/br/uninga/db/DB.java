package br.uninga.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "arboviroses";
    public static final String TBL_BAIRRO = "bairro";
    public static final String TBL_LOGRADOURO = "logradouro";
    public static final String TBL_LOCALIDADE = "localidade";
    public static final String TBL_TIPO_DE_IMOVEL = "tipo_imovel";

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

    public static final String SCRIPT_TBL_TIPO_DE_IMOVEL = " create table tipo_imovel("+
            " id string not null primary key, "+
            " sigla text, "+
            " descricao text not null);";

    public DB(Context context){
        super(context, NOME_BANCO, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SCRIPT_TBL_BAIRRO);
        db.execSQL(SCRIPT_TBL_LOGRADOURO);
        db.execSQL(SCRIPT_TBL_LOCALIDADE);
        db.execSQL(SCRIPT_TBL_TIPO_DE_IMOVEL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
