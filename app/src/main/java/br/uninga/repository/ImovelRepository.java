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
import br.uninga.model.Imovel;
import br.uninga.utils.Funcoes;

public class ImovelRepository implements IPadraoRepository {

    private static final String[] FLD_IMOVEL = {"id", "localidade","quarteirao","logradouro","numero","bairro","tipoImovel","complemento","sequencia","telefoneResidencial","telefoneRecado","observacao"};
    public SQLiteDatabase db;
    public static ImovelRepository instance = new ImovelRepository();

    public static ImovelRepository getInstance(Context context){
        if(instance.db == null || instance.db.isOpen()){
            instance.db = new DB(context).getWritableDatabase();
        }
        return  instance;
    }

    @Override
    public void inserir(Object o) {
        Imovel imovel = (Imovel) o;
        long codigo = -1;
        db.beginTransaction();
        try{
            ContentValues cv = new ContentValues();
            cv.put("id", Funcoes.getUUID());
            cv.put("localidade", imovel.getLocalidade());
            cv.put("quarteirao", imovel.getQuarteirao());
            cv.put("logradouro", imovel.getLogradouro());
            cv.put("numero", imovel.getNumero());
            cv.put("bairro", imovel.getBairro());
            cv.put("tipoImovel", imovel.getTipoImovel());
            cv.put("complemento", imovel.getComplemento());
            cv.put("sequencia", imovel.getSequencia());
            cv.put("telefoneResidencial", imovel.getTelefoneResidencial());
            cv.put("telefoneRecado", imovel.getTelefoneRecado());
            cv.put("observacao", imovel.getObservacao());
            codigo = db.insert(DB.TBL_IMOVEL, null, cv);
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public void alterar(Object o) {
        Imovel imovel = (Imovel)o;
        db.beginTransaction();
        try{
            ContentValues cv = new ContentValues();
            cv.put("id", imovel.getId().trim());
            cv.put("localidade", imovel.getLocalidade());
            cv.put("quarteirao", imovel.getQuarteirao());
            cv.put("logradouro", imovel.getLogradouro());
            cv.put("numero", imovel.getNumero());
            cv.put("bairro", imovel.getBairro());
            cv.put("tipoImovel", imovel.getTipoImovel());
            cv.put("complemento", imovel.getComplemento());
            cv.put("sequencia", imovel.getSequencia());
            cv.put("telefoneResidencial", imovel.getTelefoneResidencial());
            cv.put("telefoneRecado", imovel.getTelefoneRecado());
            cv.put("observacao", imovel.getObservacao());
            db.update(DB.TBL_IMOVEL, cv, "id=?", new String[]{imovel.getId()});
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
        Imovel imovel = (Imovel)o;
        db.beginTransaction();
        try{
            db.delete(DB.TBL_IMOVEL, "id=?", new String[] {String.valueOf(imovel.getId())});
            db.setTransactionSuccessful();;
        }finally {
            db.endTransaction();
        }    }

    @Override
    public ArrayList getAll() {

        List<Imovel> lista = new ArrayList<Imovel>();
        Cursor c = db.query(DB.TBL_IMOVEL, null,null,null,null,null,null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            Imovel imovel = carregar(c);
            lista.add(imovel);
            c.moveToNext();
        }
        return new ArrayList(lista);
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    private Imovel carregar(Cursor c){
        @SuppressLint("Range") String id = c.getString(c.getColumnIndex("id"));
        @SuppressLint("Range") String localidade = c.getString(c.getColumnIndex("localidade"));
        @SuppressLint("Range") String quarteirao = c.getString(c.getColumnIndex("quarteirao"));
        @SuppressLint("Range") String logradouro = c.getString(c.getColumnIndex("logradouro"));
        @SuppressLint("Range") String numero = c.getString(c.getColumnIndex("numero"));
        @SuppressLint("Range") String bairro = c.getString(c.getColumnIndex("bairro"));
        @SuppressLint("Range") String tipoImovel = c.getString(c.getColumnIndex("tipoImovel"));
        @SuppressLint("Range") String complemento = c.getString(c.getColumnIndex("complemento"));
        @SuppressLint("Range") String sequencia = c.getString(c.getColumnIndex("sequencia"));
        @SuppressLint("Range") String telefoneResidencial = c.getString(c.getColumnIndex("telefoneResidencial"));
        @SuppressLint("Range") String telefoneRecado = c.getString(c.getColumnIndex("telefoneRecado"));
        @SuppressLint("Range") String observacao = c.getString(c.getColumnIndex("observacao"));
        Imovel imovel = new Imovel(id, localidade,quarteirao,logradouro,numero,bairro,tipoImovel,complemento,sequencia,telefoneResidencial,telefoneRecado,observacao);
        return imovel;
    }
}
