
package controlador;

import entidades.Nota;
import entidades.Persona;
import entidades.Trimestre;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pantallas.ListadoPersonas;
import pantallas.FrmNota;
import servicios.AlumnoService;

public class AlumnoController {
    private List<Trimestre> trimestres;
    private ListadoPersonas pantalla;
    private AlumnoService service;
    
    public AlumnoController(){
        service = new AlumnoService();
        trimestres = Arrays.asList(Trimestre.values());
    }
    
    public void setPantalla(ListadoPersonas pantalla){
        this.pantalla = pantalla;
        this.pantalla.cargar();
    }

    public List<Persona> getAlumnos() {
        return service.findAll();
    }

    public void verDetalleNotas(Long id) {
        Persona personaABuscar = service.getById(new Persona(id));
//        for (Persona persona : personas){
//            if(persona.getDni().equals(dni)){
//                personaABuscar = persona;
//                break;
//            }
//        }
        NotaController notaController = new NotaController();
        notaController.mostrarPantalla(personaABuscar);
    }
}
