/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chainOfResponsbility;

import java.util.List;


public class VacioValidador extends Validador{

    public VacioValidador(Validador next) {
        super(next);
    }

    @Override
    public void validar(String texto, List<String> errores) {
        if(texto.equals(""))
            errores.add("El texto no puede estar vacío.");
        next.validar(texto, errores);
    }

}
