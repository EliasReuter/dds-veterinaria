package domain.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue
    private int idCliente;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "dni")
    private int dni;
    @OneToMany(mappedBy = "cliente", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Mascota> Mascotas;
    @ManyToOne
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    private Empresa idEmpresa;

    public Cliente() {
        this.Mascotas = new ArrayList<>();
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDni() {
        return dni;
    }

    public List<Mascota> getMascotas() {
        return Mascotas;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }
}
