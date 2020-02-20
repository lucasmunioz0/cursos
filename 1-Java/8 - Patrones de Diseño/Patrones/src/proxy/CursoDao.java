package proxy;

public class CursoDao {
    
    private Object conection = new Object();
    
    public Curso buscarCursoPorNombre(String nombre){
        System.out.println("Select * from cursos where id = ?");
        return new CursoProxy(nombre, conection);
    }
}