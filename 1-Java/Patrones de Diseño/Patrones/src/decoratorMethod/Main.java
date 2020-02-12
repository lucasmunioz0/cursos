package decoratorMethod;

public class Main {
    public static void main(String[] args) {
        UserComponent auditor = new AdminUser(
                new UsuarioSecretaria(
                        new Usuario()));
        auditor.login("myuser", "1234");
    }
}
