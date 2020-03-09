
package com.udemy.sga.soap;

import com.udemy.sga.domain.Persona;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface PersonaServicesWS {
    
    @WebMethod
    public List<Persona> listarPersonas();
}
