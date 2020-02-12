/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chainOfResponsbility;

import java.util.List;


public class NullValidator extends Validador{

    public NullValidator(Validador next) {
        super(next);
    }

    @Override
    public void validar(String texto, List<String> errores) {
        if(texto == null)
            errores.add("El texto no puede ser nulo.");
        next.validar(texto, errores);
    }

}
