package proxy;

import java.util.List;

public class CursoProxy extends Curso{
    private Object connection;
    
    
    public CursoProxy(String nombre, Object connection) {
        super(nombre);
        this.connection = connection;
    }

    @Override
    public List<Alumno> getAlumno() {
        System.out.println("Select * from alumnos where curso_id = ?");
        List<Alumno> alumnos = super.getAlumno();
        alumnos.add(new Alumno("Pedro"));
        
        return alumnos;
    }
    
    
    
}
