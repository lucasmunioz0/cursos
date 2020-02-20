package com.azurecalidaddatos.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Result<T> {
    private T result;
    private boolean isOk;
    private List<String> mensajes;
    
    public Result(){
        isOk = true;
        mensajes = new LinkedList<>();
    }
    
    public void setResult(T result){
        this.result = result;
    }
    
    public T getResult(){
        return result;
    }
    
    public void agregarMensaje(String mensaje){
        if(mensaje != null && !mensaje.isEmpty())
            mensajes.add(mensaje);
    }
    
    public void agregarMensajeError(String mensaje){
        if(mensaje != null && !mensaje.isEmpty())
            mensajes.add(mensaje);
        isOk = false;
    }
    
    public boolean isOk(){
        return isOk;
    }
    
    public List<String> getMensajes(){
        return new ArrayList<>(mensajes);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        mensajes.forEach(sb::append);
        
        return sb.toString();
    }
}