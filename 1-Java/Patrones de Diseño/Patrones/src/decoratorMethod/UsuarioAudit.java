package decoratorMethod;

public class UsuarioAudit extends Role{

    public UsuarioAudit(UserComponent userComponent) {
        super(userComponent);
    }
    
    @Override
    public void login(String usuario, String password) {
        userComponent.login(usuario, password);
        System.out.println("El usuario audit se logeo.");
    }

}
