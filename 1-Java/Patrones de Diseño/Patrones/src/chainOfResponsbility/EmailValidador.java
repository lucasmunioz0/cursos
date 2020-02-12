/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chainOfResponsbility;

import java.util.List;


public class EmailValidador extends Validador{

    public EmailValidador(Validador next) {
        super(next);
    }

    @Override
    public void validar(String texto, List<String> errores) {
        if(!texto.contains("@"))
            errores.add("El texto ingresado debe ser un email.");
        next.validar(texto, errores);
    }

}
