package domain.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "mascota")
public class Mascota {
    @Id
    @GeneratedValue
    private int idMascota;
    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "mascota", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<FichaMedica> fichasmedicas;

    public Mascota() {
        this.fichasmedicas = new ArrayList<>();
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<FichaMedica> getFichasMedicas() {
        return fichasmedicas;
    }

    public void setFichasMedicas(List<FichaMedica> fichasMedicas) {
        this.fichasmedicas = fichasMedicas;
    }
}
