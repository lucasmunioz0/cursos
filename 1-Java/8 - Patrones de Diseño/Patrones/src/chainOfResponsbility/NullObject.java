/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chainOfResponsbility;

import java.util.List;


public class NullObject extends Validador{

    public NullObject() {
        super(null);
    }

    @Override
    public void validar(String texto, List<String> errores) {
        //No hace nada
    }
}