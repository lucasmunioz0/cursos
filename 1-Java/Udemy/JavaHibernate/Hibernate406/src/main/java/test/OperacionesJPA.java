package test;

import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;

public class OperacionesJPA {
    public static void main(String[] args) {
        PersonaDao dao = new PersonaDao();
        for (Persona persona : dao.getAll()) {
            System.out.println(persona);
        }
        
        Persona persona = new Persona();
        persona.setNombre("Carlos");
        persona.setApellido("Lara");
        persona.setEmail("cl2@gmail.com");
        
//        dao.insert(persona);
        persona.setIdPersona(2l);
        
        persona.setNombre("Carlos MODIFICADO");
        dao.update(persona);
        
        for (Persona persona2 : dao.getAll()) {
            System.out.println(persona2);
        }
//        System.out.println(dao.get(2));
    }
}
