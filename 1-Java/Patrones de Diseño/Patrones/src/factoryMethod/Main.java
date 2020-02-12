package factoryMethod;

public class Main {

    public static void main(String[] args) {
        FactoryMethod.createBoton().click();
        FactoryMethod.createCajaDeTexto().dibujar();
        FactoryMethod.createBoton().click();
        FactoryMethod.createCajaDeTexto().dibujar();
    }
}
