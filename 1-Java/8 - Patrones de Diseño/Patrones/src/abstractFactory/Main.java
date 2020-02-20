package abstractFactory;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String lookAndFeel = "rectangular";
        Map<String, AbstractFactory> factories = new HashMap<>();
        factories.put("rectangular", new RectagularFactory());
        factories.put("circular", new CircularFactory());

        factories.get(lookAndFeel).createBoton().click();
        factories.get(lookAndFeel).createCajaDeTexto().dibujar();
        factories.get(lookAndFeel).createBoton().click();
        factories.get(lookAndFeel).createCajaDeTexto().dibujar();
    }
}
