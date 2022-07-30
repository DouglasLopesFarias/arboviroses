package br.uninga.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

import br.uninga.model.CadPNCD;
import br.uninga.repository.CadPNCDRepository;
import br.uninga.view.CadPNCDActivity;

public class PncdAsync {

    public  static DadosSincronizados sincronizarPNCD(String retorno){
        Gson gson = new GsonBuilder().create();
        Type type = new TypeToken<List<CadPNCD>>(){}.getType();
        List<CadPNCD> lista = gson.fromJson(retorno, type);
        for (CadPNCD obj: lista) {
            Log.e("obj: ", obj.toString());
        }
        return new DadosSincronizados("OK",  String.valueOf(lista.size()), "0", lista);
    }

}
