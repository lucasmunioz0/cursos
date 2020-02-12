/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package state;


public abstract class ArmaDisparable implements Arma{
    private int municion;
    private Personaje personaje;
    
    public ArmaDisparable(int municion, Personaje personaje) {
        this.municion = municion;
        this.personaje = personaje;
    }    

    @Override
    public void atacar() {
        if(municion > 0){
            System.out.println("Se disparo " + this.getClass().getSimpleName());
            municion--;
        }else{
            personaje.pasarArmaAnterior();
            personaje.atacar();
        }
    }
}
