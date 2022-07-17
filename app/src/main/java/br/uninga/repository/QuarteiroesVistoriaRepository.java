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
import br.uninga.model.QuarteiroesVistoria;
import br.uninga.utils.Funcoes;

public class QuarteiroesVistoriaRepository implements IPadraoRepository {

    private static final String[] FLD_QUARTEIROES_VISTORIAS = {"id", "localidade", "numero", "id_agente", "id_quarteirao", "observacao"};

    public SQLiteDatabase db;
    public static QuarteiroesVistoriaRepository instance = new QuarteiroesVistoriaRepository();

    public static QuarteiroesVistoriaRepository getInstance(Context context){
        if(instance.db == null || instance.db.isOpen()){
            instance.db = new DB(context).getWritableDatabase();
        }
        return  instance;
    }

    @Override
    public void inserir(Object o) {
        QuarteiroesVistoria quarteiroesVistoria = (QuarteiroesVistoria)o;
        long codigo = -1;
        db.beginTransaction();
        try{
            ContentValues cv = new ContentValues();
            cv.put("id", Funcoes.getUUID());
            cv.put("localidade", quarteiroesVistoria.getLocalidade());
            cv.put("numero", quarteiroesVistoria.getNumero());
            cv.put("id_agente", quarteiroesVistoria.getId_agente());
            cv.put("id_quarteirao", quarteiroesVistoria.getId_quarteirao());
            cv.put("observacao", quarteiroesVistoria.getObservacao());
            codigo = db.insert(DB.TBL_QUARTEIROES_VISTORIAS, null, cv);
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public void alterar(Object o) {
        QuarteiroesVistoria quarteiroesVistoria = (QuarteiroesVistoria)o;
        db.beginTransaction();
        try{
            ContentValues cv = new ContentValues();
            cv.put("id", Funcoes.getUUID());
            cv.put("localidade", quarteiroesVistoria.getLocalidade());
            cv.put("numero", quarteiroesVistoria.getNumero());
            cv.put("id_agente", quarteiroesVistoria.getId_agente());
            cv.put("id_quarteirao", quarteiroesVistoria.getId_quarteirao());
            cv.put("observacao", quarteiroesVistoria.getObservacao());
            db.update(DB.TBL_QUARTEIROES_VISTORIAS, cv, "id=?", new String[]{quarteiroesVistoria.getId()});
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
        QuarteiroesVistoria quarteiroesVistoria = (QuarteiroesVistoria)o;
        db.beginTransaction();
        try{
            db.delete(DB.TBL_QUARTEIROES_VISTORIAS, "id=?", new String[] {String.valueOf(quarteiroesVistoria.getId())});
            db.setTransactionSuccessful();;
        }finally {
            db.endTransaction();
        }

    }

    @Override
    public ArrayList getAll() {
        List<QuarteiroesVistoria> lista = new ArrayList<QuarteiroesVistoria>();
        Cursor c = db.query(DB.TBL_QUARTEIROES_VISTORIAS, null,null,null,null,null,null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            QuarteiroesVistoria quarteiroesVistoria = carregar(c);
            lista.add(quarteiroesVistoria);
            c.moveToNext();
        }
        return new ArrayList(lista);
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    private QuarteiroesVistoria carregar(Cursor c){
        @SuppressLint("Range") String id = c.getString(c.getColumnIndex("id"));
        @SuppressLint("Range") String localidade = c.getString(c.getColumnIndex("localidade"));
        @SuppressLint("Range") String numero = c.getString(c.getColumnIndex("numero"));
        @SuppressLint("Range") String id_agente = c.getString(c.getColumnIndex("id_agente"));
        @SuppressLint("Range") String id_quarteirao = c.getString(c.getColumnIndex("id_quarteirao"));
        @SuppressLint("Range") String observacao = c.getString(c.getColumnIndex("observacao"));
        QuarteiroesVistoria quarteiroesVistoria = new QuarteiroesVistoria(id, localidade, numero, id_agente, id_quarteirao, observacao);
        return quarteiroesVistoria;
    }
}
