package br.uninga.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "arboviroses";
    public static final String TBL_BAIRRO = "bairro";

    public static final String SCRIPT_TBL_CLIENTES = " create table bairro("+
            " id string not null primary key, "+
            " descricao text not null);";

    public DB(Context context){
        super(context, NOME_BANCO, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SCRIPT_TBL_CLIENTES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
