/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decoratorMethod;


public class Usuario implements UserComponent{
    
    @Override
    public void login(String login, String password){
        System.out.println("El usuario común se logeo.");
    }
    
    public void hacerAlgoDeUsuarioComun(){
        System.out.println("Este es mi usuario común.");
    }
}
