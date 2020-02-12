package builder;

public class AlumnoBuilder {
    private Long id;
    private String nombre;
    private String apellido;
    
    private String url;
    private Alumno alumno;

    public AlumnoBuilder(String url) {
        this.url = url;
    }    

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void build(){
        System.out.println("Operación muy complicada");
        alumno = new Alumno(id, nombre, apellido);
    }

    public Alumno getAlumno() {
        return alumno;
    }
}
