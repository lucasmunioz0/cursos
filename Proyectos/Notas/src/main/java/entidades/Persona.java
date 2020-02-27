package entidades;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Persona {

    private String nombre;
    private String apellido;
    private String dni;
    private List<Nota> notas;

    public Persona(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.notas = new ArrayList<>();
    }

    public Persona() {
        this(null, null, null);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Nota> getNotas(Trimestre trimestre) {
        return notas.stream().filter(nota -> nota.getTrimestre().equals(trimestre)).collect(Collectors.toList());
    }

    public void addNota(Nota nota) {
        this.notas.add(nota);
    }

    public Float calcularPromedioTrimestral(Trimestre trimestre) {
        return calcularPromedio(getNotas(trimestre));
    }

    public String calcularPromedioTrimestralStr(Trimestre trimestre) {
        final Float promedio = calcularPromedioTrimestral(trimestre);
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');

        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        return formato1.format(promedio);
    }

    public Float calcularPromedioGeneral() {
        return calcularPromedio(notas);
    }

    public String calcularPromedioGeneralStr() {
        final Float promedio = calcularPromedioGeneral();
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');

        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        return formato1.format(promedio);
    }

    private Float calcularPromedio(List<Nota> notas) {
        Float total = 0f;
        total = notas.stream().map((nota) -> nota.getValor()).reduce(total, (accumulator, _item) -> accumulator + _item);
        return notas.size() > 0 ? total / notas.size() : 0;
    }

    public String getNombreCompleto() {
        return getApellido() + ", " + getNombre();
    }

    public List<Nota> getNotas() {
        notas.sort((Nota o1, Nota o2) -> o1.getTrimestre().compareTo(o2.getTrimestre()));
        return notas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getDni() + " - " + getNombreCompleto();
    }
}
