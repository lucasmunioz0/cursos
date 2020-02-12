/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chainOfResponsbility;

import java.util.ArrayList;
import java.util.List;


public class Main2 {
    public static void main(String[] args) {
        String texto = "a@a";
        List<String> errores = new ArrayList<>();
        
        Validador email = new EmailValidador(new NullObject());
        Validador longitud = new LongitudValidador(email);
        Validador vacioValidador = new VacioValidador(longitud);
        Validador nullValidador = new NullValidator(vacioValidador);
        nullValidador.validar(texto, errores);
        
        errores.forEach(error -> {System.out.println(error);});
    }
}
