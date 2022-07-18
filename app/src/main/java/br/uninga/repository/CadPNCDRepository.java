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
import br.uninga.model.CadPNCD;
import br.uninga.utils.Funcoes;

public class CadPNCDRepository implements IPadraoRepository{

    private static final String[] FLD_PNCD = {"data","hora","a1","a2","b","c","d1","d2","e","tipo01","quantidade01","tipo02","quantidade02","tipodeImovel","numero","complemento","sequencia","numerodeMoradores","telefoneResidencial","telefoneRecado","nomeMorador","cpf","dataNascimento","numerodoCartaoSus"};
    public SQLiteDatabase db;
    public static CadPNCDRepository instance = new CadPNCDRepository();

    public static CadPNCDRepository getInstance(Context context){
        if(instance.db == null || instance.db.isOpen()){
            instance.db = new DB(context).getWritableDatabase();
        }
        return  instance;
    }

    @Override
    public void inserir(Object o) {
        CadPNCD cadPNCD = (CadPNCD) o;
        long codigo = -1;
        db.beginTransaction();
        try{
            ContentValues cv = new ContentValues();
            cv.put("id", Funcoes.getUUID());
            cv.put("data", cadPNCD.getData());
            cv.put("hora", cadPNCD.getHora());
            cv.put("a1", cadPNCD.getA1());
            cv.put("a2", cadPNCD.getA2());
            cv.put("b", cadPNCD.getB());
            cv.put("c", cadPNCD.getC());
            cv.put("d1", cadPNCD.getD1());
            cv.put("d2", cadPNCD.getD2());
            cv.put("e", cadPNCD.getE());
            cv.put("tipo01", cadPNCD.getTipo01());
            cv.put("quantidade01", cadPNCD.getQuantidade01());
            cv.put("tipo02", cadPNCD.getTipo02());
            cv.put("quantidade02", cadPNCD.getQuantidade02());
            cv.put("tipodeImovel", cadPNCD.getTipodeImovel());
            cv.put("numero", cadPNCD.getNumero());
            cv.put("complemento", cadPNCD.getComplemento());
            cv.put("sequencia", cadPNCD.getSequencia());
            cv.put("numerodeMoradores", cadPNCD.getNumerodeMoradores());
            cv.put("telefoneResidencial", cadPNCD.getTelefoneResidencial());
            cv.put("telefoneRecado", cadPNCD.getTelefoneRecado());
            cv.put("nomeMorador", cadPNCD.getNomeMorador());
            cv.put("cpf", cadPNCD.getCpf());
            cv.put("dataNascimento", cadPNCD.getDataNascimento());
            cv.put("numerodoCartaoSus", cadPNCD.getNumerodoCartaoSus());
            codigo = db.insert(DB.TBL_TELACAD_PNCD, null, cv);
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public void alterar(Object o) {
        CadPNCD cadPNCD = (CadPNCD)o;
        db.beginTransaction();
        try{
            ContentValues cv = new ContentValues();
            cv.put("id", cadPNCD.getId().trim());
            cv.put("data", cadPNCD.getData());
            cv.put("hora", cadPNCD.getHora());
            cv.put("a1", cadPNCD.getA1());
            cv.put("a2", cadPNCD.getA2());
            cv.put("b", cadPNCD.getB());
            cv.put("c", cadPNCD.getC());
            cv.put("d1", cadPNCD.getD1());
            cv.put("d2", cadPNCD.getD2());
            cv.put("e", cadPNCD.getE());
            cv.put("tipo01", cadPNCD.getTipo01());
            cv.put("quantidade01", cadPNCD.getQuantidade01());
            cv.put("tipo02", cadPNCD.getTipo02());
            cv.put("quantidade02", cadPNCD.getQuantidade02());
            cv.put("tipodeImovel", cadPNCD.getTipodeImovel());
            cv.put("numero", cadPNCD.getNumero());
            cv.put("complemento", cadPNCD.getComplemento());
            cv.put("sequencia", cadPNCD.getSequencia());
            cv.put("numerodeMoradores", cadPNCD.getNumerodeMoradores());
            cv.put("telefoneResidencial", cadPNCD.getTelefoneResidencial());
            cv.put("telefoneRecado", cadPNCD.getTelefoneRecado());
            cv.put("nomeMorador", cadPNCD.getNomeMorador());
            cv.put("cpf", cadPNCD.getCpf());
            cv.put("dataNascimento", cadPNCD.getDataNascimento());
            cv.put("numerodoCartaoSus", cadPNCD.getNumerodoCartaoSus());
            db.update(DB.TBL_TELACAD_PNCD, cv, "id=?", new String[]{cadPNCD.getId()});
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
        CadPNCD cadPNCD = (CadPNCD) o;
        db.beginTransaction();
        try{
            db.delete(DB.TBL_TELACAD_PNCD, "id=?", new String[] {String.valueOf(cadPNCD.getId())});
            db.setTransactionSuccessful();;
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public ArrayList getAll() {
        List<CadPNCD> lista = new ArrayList<CadPNCD>();
        Cursor c = db.query(DB.TBL_TELACAD_PNCD, null,null,null,null,null,null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            CadPNCD cadPNCD = carregar(c);
            lista.add(cadPNCD);
            c.moveToNext();
        }
        return new ArrayList(lista);
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    private CadPNCD carregar(Cursor cursor){
        @SuppressLint("Range") String id = cursor.getString(cursor.getColumnIndex("id"));
        @SuppressLint("Range") String data = cursor.getString(cursor.getColumnIndex("data"));
        @SuppressLint("Range") String hora = cursor.getString(cursor.getColumnIndex("hora"));
        @SuppressLint("Range") String a1 = cursor.getString(cursor.getColumnIndex("a1"));
        @SuppressLint("Range") String a2 = cursor.getString(cursor.getColumnIndex("a2"));
        @SuppressLint("Range") String b = cursor.getString(cursor.getColumnIndex("b"));
        @SuppressLint("Range") String c = cursor.getString(cursor.getColumnIndex("c"));
        @SuppressLint("Range") String d1 = cursor.getString(cursor.getColumnIndex("d1"));
        @SuppressLint("Range") String d2 = cursor.getString(cursor.getColumnIndex("d2"));
        @SuppressLint("Range") String e = cursor.getString(cursor.getColumnIndex("e"));
        @SuppressLint("Range") String tipo01 = cursor.getString(cursor.getColumnIndex("tipo01"));
        @SuppressLint("Range") String quantidade01 = cursor.getString(cursor.getColumnIndex("quantidade01"));
        @SuppressLint("Range") String tipo02 = cursor.getString(cursor.getColumnIndex("tipo02"));
        @SuppressLint("Range") String quantidade02 = cursor.getString(cursor.getColumnIndex("quantidade02"));
        @SuppressLint("Range") String tipodeImovel = cursor.getString(cursor.getColumnIndex("tipodeImovel"));
        @SuppressLint("Range") String numero = cursor.getString(cursor.getColumnIndex("numero"));
        @SuppressLint("Range") String complemento = cursor.getString(cursor.getColumnIndex("complemento"));
        @SuppressLint("Range") String sequencia = cursor.getString(cursor.getColumnIndex("sequencia"));
        @SuppressLint("Range") String numerodeMoradores = cursor.getString(cursor.getColumnIndex("numerodeMoradores"));
        @SuppressLint("Range") String telefoneResidencial = cursor.getString(cursor.getColumnIndex("telefoneResidencial"));
        @SuppressLint("Range") String telefoneRecado = cursor.getString(cursor.getColumnIndex("telefoneRecado"));
        @SuppressLint("Range") String nomeMorador = cursor.getString(cursor.getColumnIndex("nomeMorador"));
        @SuppressLint("Range") String cpf = cursor.getString(cursor.getColumnIndex("cpf"));
        @SuppressLint("Range") String dataNascimento = cursor.getString(cursor.getColumnIndex("dataNascimento"));
        @SuppressLint("Range") String numerodoCartaoSus = cursor.getString(cursor.getColumnIndex("numerodoCartaoSus"));
        CadPNCD cadPNCD = new CadPNCD(id, data,hora,a1,a2,b,c,d1,d2,e,tipo01,quantidade01,tipo02, quantidade02, tipodeImovel,complemento, numero ,sequencia, numerodeMoradores,telefoneResidencial, telefoneRecado, nomeMorador,cpf, dataNascimento,numerodoCartaoSus);
        return cadPNCD;
    }

}

