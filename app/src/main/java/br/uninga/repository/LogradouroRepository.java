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
import br.uninga.model.Logradouro;
import br.uninga.utils.Funcoes;


public class LogradouroRepository implements IPadraoRepository {

    private static final String[] FLD_LOGRADOURO = {"id", "descricao"};
    public SQLiteDatabase db;
    public static LogradouroRepository instance = new LogradouroRepository();

    public static LogradouroRepository getInstance(Context context){
        if(instance.db == null || instance.db.isOpen()){
            instance.db = new DB(context).getWritableDatabase();
        }
        return  instance;
    }

    @Override
    public void inserir(Object o) {
        Logradouro logradouro = (Logradouro) o;
        long codigo = -1;
        db.beginTransaction();
        try{
            ContentValues cv = new ContentValues();
            cv.put("id", Funcoes.getUUID());
            cv.put("descricao", logradouro.getDescricao());
            codigo = db.insert(DB.TBL_LOGRADOURO, null, cv);
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }

    }

    @Override
    public void alterar(Object o) {

        Logradouro logradouro = (Logradouro) o;
        db.beginTransaction();
        try{
            ContentValues cv = new ContentValues();
            cv.put("id", logradouro.getId().trim());
            cv.put( "descricao" , logradouro.getDescricao());
            db.update(DB.TBL_LOGRADOURO, cv, "id=?", new String[]{logradouro.getId()});
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

        Logradouro logradouro = (Logradouro) o;
        db.beginTransaction();
        try{
            db.delete(DB.TBL_LOGRADOURO, "id=?", new String[] {String.valueOf(logradouro.getId())});
            db.setTransactionSuccessful();;
        }finally {
            db.endTransaction();
        }

    }

    @Override
    public ArrayList getAll() {
        List<Logradouro> lista = new ArrayList<Logradouro>();
        Cursor c = db.query(DB.TBL_LOGRADOURO, null,null,null,null,null,null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            Logradouro logradouro = carregar(c);
            lista.add(logradouro);
            c.moveToNext();
        }
        return  new ArrayList(lista);
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    private Logradouro carregar(Cursor c){
        @SuppressLint("Range") String id = c.getString(c.getColumnIndex("id"));
        @SuppressLint("Range") String descricao = c.getString(c.getColumnIndex("descricao"));
        Logradouro logradouro = new Logradouro(id, descricao);
        return logradouro;
    }
}
