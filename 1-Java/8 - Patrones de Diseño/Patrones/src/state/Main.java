package state;

public class Main {

    public static void main(String[] args) {
        Personaje personaje = new Personaje();
        personaje.atacar();
        personaje.atacar();
        personaje.atacar();
        personaje.add(new Pistola(2, personaje));
        personaje.atacar();
        personaje.add(new Rifle(2, personaje));
        personaje.atacar();
        personaje.atacar();
        personaje.atacar();
        personaje.atacar();
    }
}