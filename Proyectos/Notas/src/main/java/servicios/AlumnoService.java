package servicios;

import datos.DaoNota;
import datos.DaoPersona;
import entidades.Nota;
import entidades.Persona;
import java.util.List;

public class AlumnoService implements IServiceBase<Persona>{
    private DaoPersona dao;
    private DaoNota daoNota;
    
    public AlumnoService(){
        dao = new DaoPersona();
        daoNota = new DaoNota();
    }

    @Override
    public List<Persona> findAll() {
        return dao.findAll();
    }

    @Override
    public Persona getById(Persona persona) {
        Persona aBuscar = dao.getById(persona);
        List<Nota> notas = daoNota.getNotasByAlumno(aBuscar);
        aBuscar.setNotas(notas);
        return aBuscar;
    }

    @Override
    public void insert(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
