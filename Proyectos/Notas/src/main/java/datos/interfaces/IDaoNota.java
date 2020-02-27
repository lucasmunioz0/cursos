package datos.interfaces;

import entidades.Nota;
import entidades.Persona;
import java.util.List;

public interface IDaoNota extends IDaoBase<Nota>{
    public List<Nota> getNotasByAlumno(Persona persona);
}
