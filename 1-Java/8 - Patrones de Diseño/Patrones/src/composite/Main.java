package composite;

public class Main {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("u1");
        Usuario usuario2 = new Usuario("u2");
        Usuario usuario3 = new Usuario("u3");
        Grupo grupoA = new Grupo();
        grupoA.add(usuario2);
        grupoA.add(usuario1);
        
        Grupo grupoB = new Grupo();
        grupoB.add(usuario3);
        
        Grupo grupoC = new Grupo();
        grupoC.add(grupoA);
        grupoC.add(grupoB);
        grupoC.add(usuario1);
        grupoA.enviarMail();
        grupoB.enviarMail();
        grupoC.enviarMail();
    }
}