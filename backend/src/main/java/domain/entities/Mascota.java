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
    private Cliente idCliente;

    @OneToMany(mappedBy = "mascota", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<FichaMedica> fichasMedicas;

    public Mascota() {
        this.fichasMedicas = new ArrayList<>();
    }

    public int getIdMascota() {
        return idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public List<FichaMedica> getFichasMedicas() {
        return fichasMedicas;
    }
}
