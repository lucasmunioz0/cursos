package builder;

//Builder = Ensamblador
/*
    Constructores vs Setters
    La desventaja Usando constructores nos podemos equivocar en el orden de los parámetros.

    Usando Setters podemos ser más explícitos en las asignaciones y no hay orden en las mismas.
    La desventaja de los setters es que nos podemos olvidar de settear algun atributo.

    Regla: Si hay mas de 3 parametros usar setters, sino constructores.
           Sino podemos usar el builder, porque todavia el objeto en si no existe.
    

*/

public class Main {
    public static void main(String[] args) {
        AlumnoBuilder builder = new AlumnoBuilder("url");
        builder.setApellido("Illobre");
        builder.setNombre("Carlos");
        builder.setNombre("Gustavo");
        builder.setId(23L);
        builder.build();
        Alumno alumno = builder.getAlumno();
        
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
