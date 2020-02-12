package templateMethod;

public class LectorArchivoXML extends LectorArchivo{
    
    protected Alumno[] procesar(){
        System.out.println("Procesar XML " + file.toString());
        return new Alumno[3];
    }
}
