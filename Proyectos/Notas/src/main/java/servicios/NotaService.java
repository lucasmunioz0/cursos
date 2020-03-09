package servicios;

import datos.DaoNota;
import datos.interfaces.IDaoNota;
import entidades.Nota;
import entidades.Persona;
import java.util.List;

public class NotaService implements INotaService{
    private IDaoNota dao;

    public NotaService() {
        dao = new DaoNota();
    }

    @Override
    public List<Nota> getNotasByAlumno(Persona persona) {
        return dao.getNotasByAlumno(persona);
    }

    @Override
    public List<Nota> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Nota getById(Nota t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Nota nota) {
        dao.insert(nota);
    }

    @Override
    public void update(Nota nota) {
        dao.update(nota);
    }

    @Override
    public void delete(Nota nota) {
        dao.delete(nota);
    }
    
    @Override
    public void insertOrUpdate(Nota nota) {
        if(nota.getIdNota() != null && nota.getIdNota() > 0){
            update(nota);
        }else{
            insert(nota);
        }
    }    
}
