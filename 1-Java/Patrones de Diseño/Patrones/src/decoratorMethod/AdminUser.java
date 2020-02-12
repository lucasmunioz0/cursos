/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decoratorMethod;


public class AdminUser extends Role{

    public AdminUser(UserComponent userComponent) {
        super(userComponent);
    }
    
    @Override
    public void login(String login, String password){
        userComponent.login(login, password);
        System.out.println("El usuario admin se logeo.");
    }
}
