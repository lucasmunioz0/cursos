/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flyweight;


public class DaoLocator {
    private static AlumnoDao alumnoDao = new AlumnoDao();
    private static Object cursoDao = "";
     static AlumnoDao getAlumnoDao(){        
        //return new AlumnoDao(); No hago esto porque justamente se quiere evitar crear un objeto nuevo.
            
        
        return alumnoDao;
    }
}
