package memento;

public class Memento {
    public static void main(String[] args) {
        Alumno alumno = new Alumno();
        alumno.setApellido("Illobre");
        alumno.setNombre("Carlos");
        alumno.setNombre("Gustavo");
        alumno.setId(34L);
        
        System.out.println(alumno);
        alumno.undo(); 
        System.out.println(alumno);
        alumno.undo();
        System.out.println(alumno);
        alumno.undo();
        System.out.println(alumno);
        alumno.undo();
        System.out.println(alumno);
    }
}
