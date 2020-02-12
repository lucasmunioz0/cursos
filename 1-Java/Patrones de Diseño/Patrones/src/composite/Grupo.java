package composite;

import java.util.LinkedList;
import java.util.List;

public class Grupo implements Composite{
    private List<Composite> composites = new LinkedList<>();

    public void add(Composite composite) {
        composites.add(composite);
    }

    public void enviarMail() {
        composites.forEach(usuario -> {
            usuario.enviarMail();
        });
    }
}