package entidades;

public class Nota {
    private Long idNota;
    private float valor;
    private Trimestre trimestre;
    private Persona persona;

    public Nota() {
        this(null);
    }

    public Nota(float valor, Trimestre trimestre, Persona persona) {
        this(null, valor, trimestre, persona);
    }

    public Nota(Long idNota, float valor, Trimestre trimestre, Persona persona) {
        this.idNota = idNota;
        this.valor = valor;
        this.trimestre = trimestre;
        this.persona = persona;
    }

    public Nota(Long idNota) {
        this(idNota, null, null);
    }

    public Nota(Long idNota, Float valor, Trimestre trimestre) {
        this(idNota, valor, trimestre, null);
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Long getIdNota() {
        return idNota;
    }

    public void setIdNota(Long idNota) {
        this.idNota = idNota;
    }
}