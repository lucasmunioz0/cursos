package ar.com.educacionit.patrones.main;

import ar.com.educacionit.patrones.actores.FiatUno;
import ar.com.educacionit.patrones.actores.FordFiesta;
import ar.com.educacionit.patrones.decoradores.AireAcondicionado;
import ar.com.educacionit.patrones.decoradores.CdPlayer;
import ar.com.educacionit.patrones.decoradores.Gasoil;
import ar.com.educacionit.patrones.decoradores.Mp3Player;
import ar.com.educacionit.patrones.interfaces.Vendible;

public class Main {

    public static void main(String[] args) {
        Vendible auto = new FiatUno();
        auto = new CdPlayer(auto);
        auto = new Gasoil(auto);

        System.out.println(auto.getDescripcion());
        System.out.println("Su precio es: " + auto.getPrecio());

        Vendible auto2 = new FordFiesta();
        auto2 = new Mp3Player(auto2);
        auto2 = new Gasoil(auto2);
        auto2 = new AireAcondicionado(auto2);

        System.out.println(auto2.getDescripcion());
        System.out.println("Su precio es: " + auto2.getPrecio());
    }
}
