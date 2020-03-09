import controlador.AlumnoController;
import pantallas.ListadoPersonas;

public class Main {    
    public static void main(String[] args) {
        AlumnoController controller = new AlumnoController();
        ListadoPersonas pantalla = new ListadoPersonas(controller);
        controller.setPantalla(pantalla);
        pantalla.setVisible(true);
    }
}
