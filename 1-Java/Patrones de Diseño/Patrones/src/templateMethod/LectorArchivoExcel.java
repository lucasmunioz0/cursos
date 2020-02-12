/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templateMethod;


public class LectorArchivoExcel extends LectorArchivo{
    
    protected Alumno[] procesar(){
        System.out.println("Procesar Excel " + file.toString());
        return new Alumno[2];
    }
    
    
}
