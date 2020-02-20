package adapter;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String lookAndFeel = "hexagonal";
        Map<String, AbstractFactory> factories = new HashMap<>();
        factories.put("rectangular", new RectagularFactory());
        factories.put("circular", new CircularFactory());
        factories.put("hexagonal", new HexagonalFactory());

        factories.get(lookAndFeel).createBoton().click();
        factories.get(lookAndFeel).createCajaDeTexto().dibujar();
        factories.get(lookAndFeel).createBoton().click();
        factories.get(lookAndFeel).createCajaDeTexto().dibujar();
    }
}
