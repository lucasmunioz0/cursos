package clase6;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empresas")
public class Compania {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    
    @ManyToMany
    @JoinTable(
            name = "companias_clientes",
            joinColumns = {
                @JoinColumn(name="id_compania"),
            },
            inverseJoinColumns = {
                @JoinColumn(name="id_cliente")
            }
    )
    private List<Cliente> clientes;

    public Compania() {
    }

    public Compania(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "Compania{" + "id=" + id + ", nombre=" + nombre + ", clientes=" + clientes + '}';
    }
    
    
}
