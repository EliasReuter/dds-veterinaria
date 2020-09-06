package domain.entities;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue
    private int idEmpresa;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "cuit")
    private int cuit;
    @OneToMany(mappedBy = "empresa", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Encuesta> Encuestas;
    @OneToMany(mappedBy = "empresa", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Establecimiento> Establecimientos;
    @OneToMany(mappedBy = "empresa", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Cliente> clientes;
    @OneToMany(mappedBy = "empresa", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<FichaMedica> fichasMedicas;

    public Empresa() {
        this.Encuestas = new ArrayList<>();
        this.Establecimientos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.fichasMedicas = new ArrayList<>();
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCuit() {
        return cuit;
    }

    public List<Encuesta> getEncuestas() {
        return Encuestas;
    }

    public List<Establecimiento> getEstablecimientos() {
        return Establecimientos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<FichaMedica> getFichasMedicas() {
        return fichasMedicas;
    }
}
