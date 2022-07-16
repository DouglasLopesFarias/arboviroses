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

import br.uninga.model.Quarteirao;
import br.uninga.utils.Funcoes;

public class QuarteiraoRepository implements IPadraoRepository {

    private static final String[] FLD_Quarteirao = {"id", "localidade", "numero", "observacao"};
    public SQLiteDatabase db;
    public static QuarteiraoRepository instance = new QuarteiraoRepository();

    public static QuarteiraoRepository getInstance(Context context){
        if(instance.db == null || instance.db.isOpen()){
            instance.db = new DB(context).getWritableDatabase();
        }
        return  instance;
    }

    @Override
    public void inserir(Object o) {
        Quarteirao quarteirao = (Quarteirao)o;
        long codigo = -1;
        db.beginTransaction();
        try{
            ContentValues cv = new ContentValues();
            cv.put("id", Funcoes.getUUID());
            cv.put("localidade", quarteirao.getLocalidade());
            cv.put("numero", quarteirao.getNumero());
            cv.put("observacao", quarteirao.getObservacao());
            codigo = db.insert(DB.TBL_QUARTEIRAO, null, cv);
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public void alterar(Object o) {
        Quarteirao quarteirao = (Quarteirao) o;
        db.beginTransaction();
        try{
            ContentValues cv = new ContentValues();
            cv.put("id", quarteirao.getId().trim());
            cv.put("localidade", quarteirao.getLocalidade());
            cv.put("numero", quarteirao.getNumero());
            cv.put("observacao", quarteirao.getObservacao());
            db.update(DB.TBL_QUARTEIRAO, cv, "id=?", new String[]{quarteirao.getId()});
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
        Quarteirao quarteirao = (Quarteirao) o;
        db.beginTransaction();
        try{
            db.delete(DB.TBL_QUARTEIRAO, "id=?", new String[] {String.valueOf(quarteirao.getId())});
            db.setTransactionSuccessful();;
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public ArrayList getAll() {
        List<Quarteirao> lista = new ArrayList<Quarteirao>();
        Cursor c = db.query(DB.TBL_QUARTEIRAO, null,null,null,null,null,null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            Quarteirao quarteirao = carregar(c);
            lista.add(quarteirao);
            c.moveToNext();
        }
        return new ArrayList(lista);
    }

    @Override
    public Object getById(int id) {
        return null;
    }


    private Quarteirao carregar(Cursor c){
        @SuppressLint("Range") String id = c.getString(c.getColumnIndex("id"));
        @SuppressLint("Range") String localidade = c.getString(c.getColumnIndex("localidade"));
        @SuppressLint("Range") String numero = c.getString(c.getColumnIndex("numero"));
        @SuppressLint("Range") String observacao = c.getString(c.getColumnIndex("observacao"));
        Quarteirao quarteirao = new Quarteirao(id, localidade, numero, observacao);
        return quarteirao;
    }
}
