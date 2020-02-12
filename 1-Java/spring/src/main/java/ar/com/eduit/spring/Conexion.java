package ar.com.eduit.spring;

import org.springframework.stereotype.Component;

@Component
public class Conexion {

    private String url;
    private int port;

    public Conexion(String url, int port) {
        this.url = url;
        this.port = port;
    }

    public void connect() {
        System.out.println("Conectado a " + url + ":" + port);
    }

    public void close() {
        System.out.println("Desconectado a " + url + ":" + port);
    }

    public void execute(String s) {
        System.out.println(s);
    }
}
