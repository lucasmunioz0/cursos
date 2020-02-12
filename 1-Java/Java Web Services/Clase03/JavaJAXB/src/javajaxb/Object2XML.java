/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javajaxb;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author rdurante
 */
public class Object2XML {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {

        try {
            Cliente c = new Cliente();
            c.setId(1L);
            c.setEdad(25);
            c.setNombre("Juan Perez");
            JAXBContext context = JAXBContext.newInstance(Cliente.class);
            Marshaller m = context.createMarshaller();
            
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            m.marshal(c, System.out);
            m.marshal(c, new File("dato.xml"));
            
            
        } catch (JAXBException ex) {
            Logger.getLogger(Object2XML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
