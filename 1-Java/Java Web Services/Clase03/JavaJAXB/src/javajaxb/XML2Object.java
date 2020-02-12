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
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author rdurante
 */
public class XML2Object {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            JAXBContext context = JAXBContext.newInstance(Cliente.class);
            Unmarshaller u = context.createUnmarshaller();
            Cliente c = (Cliente) u.unmarshal(new File("Dato.xml"));
            System.out.println(c);

        } catch (JAXBException ex) {
            Logger.getLogger(XML2Object.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
