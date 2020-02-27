package controlador;

import entidades.Nota;
import entidades.Persona;
import entidades.Trimestre;
import java.util.Arrays;
import java.util.List;
import pantallas.FrmNota;

public class NotaController {
    private FrmNota pantalla;
    private List<Trimestre> trimestres;
    private Persona persona;

    public NotaController(Persona persona) {
        this.pantalla = new FrmNota();
        this.persona = persona;
        this.pantalla.setPersona(persona);
        this.trimestres = Arrays.asList(Trimestre.values());
        this.pantalla.setTrimestres(trimestres);
        this.pantalla.setLocationRelativeTo(null);
        this.pantalla.setController(this);
        this.pantalla.setVisible(true);        
    }
    
    public void addNota(Nota nota){
        this.persona.addNota(nota);
        this.pantalla.cargarNotas();
    }
}
