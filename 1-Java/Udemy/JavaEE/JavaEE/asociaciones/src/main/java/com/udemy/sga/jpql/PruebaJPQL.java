package com.udemy.sga.jpql;

import com.udemy.sga.domain.Persona;
import com.udemy.sga.domain.Usuario;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PruebaJPQL {

    private static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        String jpql = null;
        Query q = null;
        List<Persona> personas = null;
        Persona persona = null;
        Iterator i = null;
        Object[] tupla = null;
        List<String> nombres = null;
        List<Usuario> usuario = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        log.debug("\n1. Consulta de todas las Personas");
        jpql = "SELECT p FROM Persona p";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);

        log.debug("\n2.Consulta de persona con Id = 2");
        jpql = "SELECT p FROM Persona p WHERE p.idPersona = 2";
        persona = (Persona) em.createQuery(jpql).getSingleResult();
        log.debug("\n\t\tPersona encontrada");
        log.debug(persona);

        log.debug("\n3.Consulta de persona con nombre = 'Lucas'");
        jpql = "SELECT p FROM Persona p WHERE p.nombre = 'Lucas'";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);

        log.debug("\n4.Consulta de datos individuales, se crea un arreglo (tupla) de tipo object de 3 columnas");
        jpql = "SELECT p.nombre as Nombre, p.apellido as Apellido, p.email as Email FROM Persona p";
        i = em.createQuery(jpql).getResultList().iterator();
        while (i.hasNext()) {
            tupla = (Object[]) i.next();
            log.debug("Nombre: " + tupla[0] + " - Apellido: " + tupla[1] + " - Email: " + tupla[2] + "\n");
        }

        log.debug("\n5.Consulta de datos individuales, se crea un arreglo (tupla) de tipo object de 2 columnas");
        jpql = "SELECT p, p.idPersona FROM Persona p";
        i = em.createQuery(jpql).getResultList().iterator();
        while (i.hasNext()) {
            tupla = (Object[]) i.next();
            log.debug("Id: " + tupla[0] + " - Id: " + tupla[1] + "\n");
        }

        log.debug("\n6.Consulta de datos individuales solamente con el id");
        jpql = "SELECT new com.udemy.sga.domain.Persona( p.idPersona ) FROM Persona p";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);

        log.debug("\n7.Valor mínimo y máximo de id persona");
        jpql = "SELECT min( p.idPersona ), max ( p.idPersona ), count( 1 ) FROM Persona p";
        i = em.createQuery(jpql).getResultList().iterator();
        tupla = (Object[]) i.next();
        log.debug("\nMÍNIMO: " + tupla[0] + " - MÁXIMO: " + tupla[1] + " - Cantidad de personas: " + tupla[2]);

        log.debug("\n8.Cuenta los nombres que son distintos");
        jpql = "SELECT COUNT( DISTINCT p.nombre ) FROM Persona p";
        i = em.createQuery(jpql).getResultList().iterator();
        log.debug("\nCantidad de personas diferentes: " + i.next());
        
        log.debug("\n9.Convierte en mayúsculas y minúsculasa el nombre y apellido.");
        jpql = "SELECT Upper(CONCAT(p.nombre, ' ', p.apellido)) as Nombre FROM Persona p";
        nombres = em.createQuery(jpql).getResultList();
        nombres.forEach(log::debug);
        
        log.debug("\n10.Obtiene persona con id igual al parametro enviado.");
        jpql = "FROM Persona p WHERE p.idPersona= :idPersona";
        q = em.createQuery(jpql);
        q.setParameter("idPersona", 2);
        persona = (Persona) q.getSingleResult();
        log.debug(persona);
        
        log.debug("\n11.Obtiene persona que contengan la letra 'a' en el nombre.");
        jpql = "FROM Persona p WHERE upper(p.nombre) like upper(:letra)";
        q = em.createQuery(jpql);
        q.setParameter("letra", "%" + "a" + "%");
        personas = q.getResultList();
        mostrarPersonas(personas);
        
        log.debug("\n12.Uso de betweens.");
        jpql = "FROM Persona p WHERE p.idPersona BETWEEN 1 AND 5";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
    }

    private static void mostrarPersonas(List<Persona> personas) {
        log.debug("\n\t\tPersonas");
        personas.forEach(log::debug);
    }
}
