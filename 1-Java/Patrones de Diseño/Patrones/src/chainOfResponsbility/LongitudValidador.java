/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chainOfResponsbility;

import java.util.List;


public class LongitudValidador extends Validador{

    public LongitudValidador(Validador next) {
        super(next);
    }

    @Override
    public void validar(String texto, List<String> errores) {
        if(texto.length() <= 3)
            errores.add("El texto debe tener al menos 4 caracteres. ");
        next.validar(texto, errores);
    }

}
