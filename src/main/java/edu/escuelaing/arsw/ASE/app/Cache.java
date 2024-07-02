package edu.escuelaing.arsw.ASE.app;

import edu.escuelaing.arsw.ASE.app.HttpConnection;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;


public class Cache {
    public static ConcurrentHashMap<String,String> consulta = new ConcurrentHashMap<>();
    public static String search(String titulo) throws IOException {
        String valor="";
        if (consulta.containsKey(titulo)){
            valor += consulta.get(titulo);
        }else{
            valor += HttpConnection.RsponseApi(titulo);
            consulta.put(titulo,valor);
        }
        return valor;
    }

}