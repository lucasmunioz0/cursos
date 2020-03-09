/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientews.servicio;

/**
 *
 * @author Lucas
 */
public class TestServicioSumarWS {
    public static void main(String[] args) {
        final ServicioSumarWS sumar = new ServicioSumarImplService().getServicioSumarImplPort();
        int sumar1 = sumar.sumar(5, 7);
        System.out.println(sumar1);
    }
}
