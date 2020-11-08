
import com.udemy.vacantes.dao.DbConnection;
import com.udemy.vacantes.dao.UsuarioDao;
import com.udemy.vacantes.dao.VacanteDao;
import com.udemy.vacantes.models.Vacante;
import com.udemy.vacantes.models.Usuario;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucas
 */
public class Main {

    public static void main(String[] args) {
//        DbConnection.getConnection();

//        VacanteDao dao = new VacanteDao();
//        
//        List<Vacante> vacantes = dao.getUltimas();
//        
////        Vacante vacante = new Vacante("prueba", "descripcion", "detalle");
////        vacante = dao.insert(vacante);
//        for (Vacante vacante : vacantes) {
//            System.out.println(vacante);
//        }
//        
//        Vacante vacante = dao.getById(3L);
//        System.out.println(vacante);
        UsuarioDao dao = new UsuarioDao();
        Usuario usuario = dao.login("admin", "12345");
        System.out.println(usuario);
    }
}
