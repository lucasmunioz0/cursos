package ar.com.educacionit.patrones.actores;

public class Cliente extends Persona {

    private int numeroDeCliente;

    public Cliente(int numeroDeCliente) {
        this.numeroDeCliente = numeroDeCliente;
    }

    @Override
    protected String getIdentificacion() {
        return String.valueOf(numeroDeCliente);
    }

    @Override
    protected String getTipoId() {
        return "numero de cliente";
    }

    public int getNumeroDeCliente() {
        return numeroDeCliente;
    }

    public void setNumeroDeCliente(int numeroDeCliente) {
        this.numeroDeCliente = numeroDeCliente;
    }
}