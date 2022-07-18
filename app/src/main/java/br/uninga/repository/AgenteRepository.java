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
import br.uninga.model.Agente;
import br.uninga.utils.Funcoes;

public class AgenteRepository implements IPadraoRepository {

    private static final String[] FLD_AGENTE = {"id", "email", "senha", "nome"};
    public SQLiteDatabase db;
    public static AgenteRepository instance = new AgenteRepository();

    public static AgenteRepository getInstance(Context context){
        if(instance.db == null || instance.db.isOpen()){
            instance.db = new DB(context).getWritableDatabase();
        }
        return  instance;
    }

    @Override
    public void inserir(Object o) {
        Agente agente = (Agente)o;
        long codigo = -1;
        db.beginTransaction();
        try{
            ContentValues cv = new ContentValues();
            cv.put("id", Funcoes.getUUID());
            cv.put("email", agente.getEmail());
            cv.put("senha", agente.getSenha());
            cv.put("nome", agente.getNome());
            codigo = db.insert(DB.TBL_AGENTE, null, cv);
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public void alterar(Object o) {
        Agente agente = (Agente)o;
        db.beginTransaction();
        try{
            ContentValues cv = new ContentValues();
            cv.put("id", agente.getId().trim());
            cv.put( "email" , agente.getEmail());
            cv.put("senha", agente.getSenha());
            cv.put("nome", agente.getNome());
            db.update(DB.TBL_AGENTE, cv, "id=?", new String[]{agente.getId()});
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
        Agente agente = (Agente)o;
        db.beginTransaction();
        try{
            db.delete(DB.TBL_AGENTE, "id=?", new String[] {String.valueOf(agente.getId())});
            db.setTransactionSuccessful();;
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public ArrayList getAll() {
        List<Agente> lista = new ArrayList<Agente>();
        Cursor c = db.query(DB.TBL_AGENTE, null,null,null,null,null,null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            Agente agente = carregar(c);
            lista.add(agente);
            c.moveToNext();
        }
        return  new ArrayList(lista);
    }

    public boolean buscarLogin(Agente a){
        List<Agente> lista = new ArrayList<Agente>();
        Cursor cursor = db.rawQuery("Select * from agente  where email = '" + a.getEmail()  + "' and senha = '" + a.getSenha() + "'", null);
        cursor.moveToFirst();
        if (!cursor.isAfterLast()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    private Agente carregar(Cursor c){
        @SuppressLint("Range") String id = c.getString(c.getColumnIndex("id"));
        @SuppressLint("Range") String email = c.getString(c.getColumnIndex("email"));
        @SuppressLint("Range") String senha = c.getString(c.getColumnIndex("senha"));
        @SuppressLint("Range") String nome = c.getString(c.getColumnIndex("nome"));
        Agente agente = new Agente(id, email, senha, nome);
        return agente;
    }
}
