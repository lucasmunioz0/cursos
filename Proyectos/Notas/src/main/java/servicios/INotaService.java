package servicios;

import entidades.Nota;
import entidades.Persona;
import java.util.List;

public interface INotaService extends IServiceBase<Nota>{
    public List<Nota> getNotasByAlumno(Persona persona);
    public void insertOrUpdate(Nota nota);
}
