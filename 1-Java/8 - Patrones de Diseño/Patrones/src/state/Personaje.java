/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package state;

import java.util.LinkedList;
import java.util.List;


public class Personaje {
    private List<Arma> armas = new LinkedList<>();
    private Arma arma = new Cuchillo();
    
    public void atacar(){
        arma.atacar();
    }

    public void add(Arma arma) {
        armas.add(this.arma);
        this.arma = arma;        
    }

    public void pasarArmaAnterior() {
        this.arma = armas.remove(armas.size() - 1);
    }
}