package beans.model;

public class Colonia {
    private int coloniaId;
    private String nombre;
    private int codigoPostal;

    public Colonia(int coloniaId, String nombre, int codigoPostal) {
        this.coloniaId = coloniaId;
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
    }

    public Colonia() {
    }

    public int getColoniaId() {
        return coloniaId;
    }

    public void setColoniaId(int coloniaId) {
        this.coloniaId = coloniaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}