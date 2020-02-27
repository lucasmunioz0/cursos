
package controlador;

import entidades.Nota;
import entidades.Persona;
import entidades.Trimestre;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pantallas.ListadoPersonas;
import pantallas.FrmNota;

public class AlumnoController {
    private List<Persona> personas;
    private List<Trimestre> trimestres;
    private ListadoPersonas pantalla;
    
    public AlumnoController(){
        final Persona p1 = new Persona("Lucas", "Muñoz", "37627180");
        final Persona p2 = new Persona("Luis", "Perez", "37627182");
        final Persona p3 = new Persona("Maria", "Jose", "37627183");
        final Persona p4 = new Persona("Pedro", "Castro", "37627184");
        personas = new ArrayList<>(4);
        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        personas.add(p4);
        trimestres = Arrays.asList(Trimestre.values());
    }
    
    public void setPantalla(ListadoPersonas pantalla){
        this.pantalla = pantalla;
        this.pantalla.cargar();
    }

    public List<Persona> getAlumnos() {
        return personas;
    }


    public void verDetalleNotas(String dni) {
        Persona personaABuscar = null;
        for (Persona persona : personas){
            if(persona.getDni().equals(dni)){
                personaABuscar = persona;
                break;
            }
        }
        NotaController nota = new NotaController(personaABuscar);
    }
}
