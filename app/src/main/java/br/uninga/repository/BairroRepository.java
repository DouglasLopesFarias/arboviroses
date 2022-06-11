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
import br.uninga.model.Bairro;

public class BairroRepository implements IPadraoRepository {

    private static final String[] FLD_BAIRRO = {"id", "descricao"};
    public SQLiteDatabase db;
    public static BairroRepository instance = new BairroRepository();

    public static BairroRepository getInstance(Context context){
        if(instance.db == null || instance.db.isOpen()){
            instance.db = new DB(context).getWritableDatabase();
        }
        return  instance;
    }

    @Override
    public void inserir(Object o) {
        Bairro bairro = (Bairro)o;
        long codigo = -1;
        db.beginTransaction();
        try{
            ContentValues cv = new ContentValues();
            cv.put("id", bairro.getId().trim());
            cv.put("descricao", bairro.getDescricao());
            codigo = db.insert(DB.TBL_BAIRRO, null, cv);
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public void alterar(Object o) {
        Bairro bairro = (Bairro)o;
        db.beginTransaction();
        try{
            ContentValues cv = new ContentValues();
            cv.put("id", bairro.getId().trim());
            cv.put( "descricao" , bairro.getDescricao());
            db.update(DB.TBL_BAIRRO, cv, "id=?", new String[]{bairro.getId()});
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
        Bairro bairro = (Bairro)o;
        db.beginTransaction();
        try{
            db.delete(DB.TBL_BAIRRO, "id=?", new String[] {String.valueOf(bairro.getId())});
            db.setTransactionSuccessful();;
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public ArrayList getAll() {
        List<Bairro> lista = new ArrayList<Bairro>();
        Cursor c = db.query(DB.TBL_BAIRRO, null,null,null,null,null,null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            Bairro bairro = carregar(c);
            lista.add(bairro);
            c.moveToNext();
        }
        return  new ArrayList(lista);
    }

    @Override
    public Object getById(int id) {
        return null;
    }


    private Bairro carregar(Cursor c){
        @SuppressLint("Range") String id = c.getString(c.getColumnIndex("id"));
        @SuppressLint("Range") String nome = c.getString(c.getColumnIndex("descricao"));
        Bairro bairro = new Bairro(id, nome);
        return bairro;
    }
}
