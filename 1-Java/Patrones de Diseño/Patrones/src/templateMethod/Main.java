/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templateMethod;

import java.util.HashMap;
import java.util.Map;


public class Main {
    //
    private static Map<String, LectorArchivo> lectoresDeArchivos = new HashMap<>();
    
    public Main(){
        lectoresDeArchivos.put("xml", new LectorArchivoXML());
        lectoresDeArchivos.put("xls", new LectorArchivoExcel());
    }
    
    public static void main(String[] args) {
        String path = "C:\\miarchivo.xls";
        Main main = new Main();
        //Pero que pasa con el if de aca? Como se puede eliminar?
        
//        if(path.endsWith(".xml")){
//            Alumno[] alumnos = new LectorArchivoXML().leer("C\\miarchivo.xml");
//        }else{
//            Alumno[] alumnos = new LectorArchivoExcel().leer("C\\miarchivo.xls");
//        }
        //Utilizando el Mapa ahora puedo eliminar el if
        String ext = path.split("\\.")[1];
        System.out.println(ext);
        LectorArchivo lector = lectoresDeArchivos.get(ext);
        Alumno[] alumnos = lector.procesar();
        
    }
}
