/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chainOfResponsbility;

import java.util.ArrayList;
import java.util.List;


public abstract class Validador {
    protected Validador next;
    
    public Validador(Validador next){
        this.next = next;
    }
    
    public abstract void validar(String texto, List<String> errores);
}
