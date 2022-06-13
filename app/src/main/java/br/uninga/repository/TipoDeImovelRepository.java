package br.uninga.repository;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.uninga.db.DB;
import br.uninga.interfaces.IPadraoRepository;
import br.uninga.model.TipoDeImovel;
import br.uninga.utils.Funcoes;

public class TipoDeImovelRepository implements IPadraoRepository {

    private static final String[] FLD_TIPO_DE_IMOVEL = {"id", "sigla", "descricao"};
    public SQLiteDatabase db;
    public static TipoDeImovelRepository instance = new TipoDeImovelRepository();

    public static TipoDeImovelRepository getInstance(Context context){
        if(instance.db == null || instance.db.isOpen()){
            instance.db = new DB(context).getWritableDatabase();
        }
        return  instance;
    }


    @Override
    public void inserir(Object o) {
        TipoDeImovel tipoDeImovel = (TipoDeImovel)o;
        long codigo = -1;
        db.beginTransaction();
        try{
            ContentValues cv = new ContentValues();
            cv.put("id", Funcoes.getUUID());
            cv.put("sigla", tipoDeImovel.getSigla());
            cv.put("descricao", tipoDeImovel.getDescricao());
            codigo = db.insert(DB.TBL_TIPO_DE_IMOVEL, null, cv);
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public void alterar(Object o) {
        TipoDeImovel tipoDeImovel = (TipoDeImovel)o;
        db.beginTransaction();
        try{
            ContentValues cv = new ContentValues();
            cv.put("id", tipoDeImovel.getId().trim());
            cv.put("sigla", tipoDeImovel.getSigla());
            cv.put( "descricao" , tipoDeImovel.getDescricao());
            db.update(DB.TBL_TIPO_DE_IMOVEL, cv, "id=?", new String[]{tipoDeImovel.getId()});
            db.setTransactionSuccessful();
        }catch(Exception e){
            Log.e("Erro: ", e.getMessage());
        }
        finally {
            db.endTransaction();
        }

    }

    @Override
    public void remover(Object o) {
        TipoDeImovel tipoDeImovel = (TipoDeImovel)o;
        db.beginTransaction();
        try{
            db.delete(DB.TBL_TIPO_DE_IMOVEL, "id=?", new String[] {String.valueOf(tipoDeImovel.getId())});
            db.setTransactionSuccessful();;
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public ArrayList getAll() {
        List<TipoDeImovel> lista = new ArrayList<TipoDeImovel>();
        Cursor c = db.query(DB.TBL_TIPO_DE_IMOVEL, null,null,null,null,null,null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            TipoDeImovel tipoDeImovel = carregar(c);
            lista.add(tipoDeImovel);
            c.moveToNext();
        }
        return  new ArrayList(lista);
    }

    @Override
    public Object getById(int id) {
        return null;
    }


    private TipoDeImovel carregar(Cursor c){
        @SuppressLint("Range") String id = c.getString(c.getColumnIndex("id"));
        @SuppressLint("Range") String sigla = c.getString(c.getColumnIndex("sigla"));
        @SuppressLint("Range") String descricao = c.getString(c.getColumnIndex("descricao"));
        TipoDeImovel tipoDeImovel = new TipoDeImovel(id, sigla, descricao);
        return tipoDeImovel;
    }
}
