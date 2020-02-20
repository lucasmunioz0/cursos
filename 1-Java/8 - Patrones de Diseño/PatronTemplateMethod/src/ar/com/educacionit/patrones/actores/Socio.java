package ar.com.educacionit.patrones.actores;

public class Socio extends Persona {

    private int numeroDeSocio;

    public Socio(int numeroDeSocio) {
        this.numeroDeSocio = numeroDeSocio;
    }

    @Override
    protected String getIdentificacion() {
        return String.valueOf(numeroDeSocio);
    }

    @Override
    protected String getTipoId() {
        return "numero de socio";
    }

    public int getNumeroDeSocio() {
        return numeroDeSocio;
    }

    public void setNumeroDeSocio(int numeroDeSocio) {
        this.numeroDeSocio = numeroDeSocio;
    }
}
