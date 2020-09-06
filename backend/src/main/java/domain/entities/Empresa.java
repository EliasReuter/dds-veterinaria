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
    private List<Encuesta> encuestas;
    @OneToMany(mappedBy = "empresa", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Establecimiento> establecimientos;
    @OneToMany(mappedBy = "empresa", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Cliente> clientes;
    //@OneToMany(mappedBy = "empresa", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    //private List<FichaMedica> fichasMedicas;

    public Empresa() {
        this.encuestas = new ArrayList<>();
        this.establecimientos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        //this.fichasMedicas = new ArrayList<>();
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public List<Encuesta> getEncuestas() {
        return encuestas;
    }

    public void setEncuestas(List<Encuesta> encuestas) {
        this.encuestas = encuestas;
    }

    public List<Establecimiento> getEstablecimientos() {
        return establecimientos;
    }

    public void setEstablecimientos(List<Establecimiento> establecimientos) {
        this.establecimientos = establecimientos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    /*public List<FichaMedica> getFichasMedicas() {
        return fichasMedicas;
    }

    public void setFichasMedicas(List<FichaMedica> fichasMedicas) {
        this.fichasMedicas = fichasMedicas;
    }*/
}
