package proxy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String nombreCurso = "PHP";
        
        CursoDao cursoDao = new CursoDao();
        Curso curso = cursoDao.buscarCursoPorNombre(nombreCurso);
        System.out.println(curso.getFecha());
        
        List<Alumno> alumnos = curso.getAlumno();
        
        for (Alumno a : alumnos){
            System.out.println(a);
        }
    }
}
