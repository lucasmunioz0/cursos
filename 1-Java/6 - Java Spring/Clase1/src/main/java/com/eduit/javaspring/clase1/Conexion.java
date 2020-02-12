package com.eduit.javaspring.clase1;

public class Conexion {
    private String url;
    private int port;

    public Conexion(String url, int port){
        this.url = url;
        this.port = port;
    }

    public void connect(){
        System.out.println("Conectado a " + url + ":" + port);
    }

    public void close(){
        System.out.println("Desconectado a " + url + ":" + port);
    }

    public void execute(String consulta){
        System.out.println(consulta);
    }
}
