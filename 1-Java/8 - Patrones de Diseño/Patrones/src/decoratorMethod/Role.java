/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decoratorMethod;


public abstract class Role implements UserComponent{
    protected UserComponent userComponent;
    
    public Role(UserComponent userComponent){
        this.userComponent = userComponent;
    }
    
    
}
