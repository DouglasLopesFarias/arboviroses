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
import br.uninga.model.Localidade;
import br.uninga.utils.Funcoes;

public class LocalidadeRepository implements IPadraoRepository {

    private static final String[] FLD_LOCALIDADE = {"id", "descricao", "categoria", "zona", "extrato"};
    public SQLiteDatabase db;
    public static LocalidadeRepository instance = new LocalidadeRepository();

    public static LocalidadeRepository getInstance(Context context){
        if(instance.db == null || instance.db.isOpen()){
            instance.db = new DB(context).getWritableDatabase();
        }
        return  instance;
    }

    @Override
    public void inserir(Object o) {
        Localidade localidade = (Localidade) o;
        long codigo = -1;
        db.beginTransaction();
        try{
            ContentValues cv = new ContentValues();
            cv.put("id", Funcoes.getUUID());
            cv.put("descricao", localidade.getDescricao());
            cv.put("categoria", localidade.getCategoria());
            cv.put("zona", localidade.getZona());
            cv.put("extrato", localidade.getExtrato());
            codigo = db.insert(DB.TBL_LOCALIDADE, null, cv);
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public void alterar(Object o) {
        Localidade localidade = (Localidade) o;
        db.beginTransaction();
        try{
            ContentValues cv = new ContentValues();
            cv.put("id", localidade.getId().trim());
            cv.put("descricao", localidade.getDescricao());
            cv.put("categoria", localidade.getCategoria());
            cv.put("zona", localidade.getZona());
            cv.put("extrato", localidade.getExtrato());
            db.update(DB.TBL_LOCALIDADE, cv, "id=?", new String[]{localidade.getId()});
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
        Localidade localidade = (Localidade) o;
        db.beginTransaction();
        try{
            db.delete(DB.TBL_LOCALIDADE, "id=?", new String[] {String.valueOf(localidade.getId())});
            db.setTransactionSuccessful();;
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public ArrayList getAll() {

        List<Localidade> lista = new ArrayList<Localidade>();
        Cursor c = db.query(DB.TBL_LOCALIDADE, null,null,null,null,null,null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            Localidade localidade = carregar(c);
            lista.add(localidade);
            c.moveToNext();
        }
        return  new ArrayList(lista);

    }

    @Override
    public Object getById(int id) {
        return null;
    }


    private Localidade carregar(Cursor c){
        @SuppressLint("Range") String id = c.getString(c.getColumnIndex("id"));
        @SuppressLint("Range") String descricao = c.getString(c.getColumnIndex("descricao"));
        @SuppressLint("Range") String categoria = c.getString(c.getColumnIndex("categoria"));
        @SuppressLint("Range") String zona = c.getString(c.getColumnIndex("zona"));
        @SuppressLint("Range") String extrato = c.getString(c.getColumnIndex("extrato"));
        Localidade localidade = new Localidade(id, descricao, categoria, zona, extrato);
        return localidade;
    }
}
