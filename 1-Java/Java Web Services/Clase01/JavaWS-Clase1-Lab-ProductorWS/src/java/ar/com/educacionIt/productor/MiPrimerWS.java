/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionIt.productor;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Vane
 */
@WebService(serviceName = "MiPrimerWS")
public class MiPrimerWS {

    /**
     * This is a sample web service operation
     */
    
    // el wsdl se encuentra en http://localhost:8080/JavaWS-Clase1-Lab-ProductorWS/MiPrimerWS?WSDL
    @WebMethod(operationName = "hola")
    public String hello(@WebParam(name = "name") String txt) {
        return txt + "Saludos desde Educacion It!";
    }
}
