package entidades;

public enum Trimestre {
    PRIMERO,
    SEGUNDO,
    TERCERO;

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
