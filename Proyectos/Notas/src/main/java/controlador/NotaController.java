package controlador;

import entidades.Nota;
import entidades.Persona;
import entidades.Trimestre;
import java.util.Arrays;
import java.util.List;
import pantallas.FrmNota;
import servicios.INotaService;
import servicios.NotaService;

public class NotaController {
    private FrmNota pantalla;
    private INotaService service;

    public NotaController() {
        this.service = new NotaService();
        this.pantalla = new FrmNota();
        this.pantalla.setTrimestres(Arrays.asList(Trimestre.values()));
        this.pantalla.setLocationRelativeTo(null);
    }
    
    public void addNota(Nota nota){
        service.insert(nota);
    }

    public Nota actualizarNota(Long idNota, Float valor, Trimestre trimestre) {
        Nota nota = new Nota(idNota, valor, trimestre);
        service.update(nota);
        return nota;
    }

    public void mostrarPantalla(Persona persona) {
        this.pantalla.setController(this);
        List<Nota> notas = service.getNotasByAlumno(persona);
        persona.setNotas(notas);
        this.pantalla.setPersona(persona);
        this.pantalla.setVisible(true);        
    }

    public void insertOrUpdate(Nota nota) {
        service.insertOrUpdate(nota);
    }
}
