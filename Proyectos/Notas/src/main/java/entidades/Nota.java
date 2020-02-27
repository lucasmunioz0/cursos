package entidades;

public class Nota {
    private float valor;
    private Trimestre trimestre;

    public Nota() {
        this(0, null);
    }

    public Nota(float valor, Trimestre trimestre) {
        this.valor = valor;
        this.trimestre = trimestre;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Trimestre getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Trimestre trimestre) {
        this.trimestre = trimestre;
    }
}