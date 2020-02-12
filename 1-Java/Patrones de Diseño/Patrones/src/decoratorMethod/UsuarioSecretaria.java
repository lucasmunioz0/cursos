/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decoratorMethod;


public class UsuarioSecretaria extends Role{

    public UsuarioSecretaria(UserComponent userComponent) {
        super(userComponent);
    }

    @Override
    public void login(String usuario, String password) {
        userComponent.login(usuario, password);
        System.out.println("Usuario secretaria se logeo.");
    }

}
