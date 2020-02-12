package templateMethod;

public abstract class LectorArchivo {
    protected Object file;
    
    private void abrir(String path){
        System.out.println("Abrir archivo: " + path);
        file = "archivo";
    }
    
    private void cerrar(){
        System.out.println("Cerrar archivo");
    }
    
    /*
        Implementación del patrón.
    */
    public final Alumno[] leer (String path){
        abrir(path);
        Alumno[] alumnos = procesar();
        cerrar();
        return alumnos;
    }

    protected abstract Alumno[] procesar();
}
//    /*
//        Mal ejemplo: IF es falta de polimorfismo
//    */
//    public Alumno[] leer(String path) {
//        System.out.println("Abrir archivo: " + path);
//        Alumno[] alumnos;
//        System.out.println("");
//        if(path.endsWith(".xml")){
//            System.out.println("Procesar XML");
//            alumnos = new Alumno[3];
//        }else if(path.endsWith(".xls")){
//            System.out.println("Procesar Excel");
//            alumnos = new Alumno[2];            
//        }else if(path.endsWith(".json")){
//            System.out.println("Procesar JSON");
//            alumnos = new Alumno[2];
//        }else{
//            alumnos = null;
//        }
//        System.out.println("Cerrar archivo.");
//        
//        return alumnos;
//    }