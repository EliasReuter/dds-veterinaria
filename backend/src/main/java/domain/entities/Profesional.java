package domain.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profesional")
public class Profesional {
    @Id
    @GeneratedValue
    private int idProfesional;
    @Column(name = "matricula")
    private int matricula;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "activo")
    private boolean activo;
    @OneToMany(mappedBy = "profesional", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Turno> turnos;
    @OneToMany(mappedBy = "profesional", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<FichaMedica> fichasMedicas;

    public Profesional() {
        this.fichasMedicas = new ArrayList<>();
        this.turnos = new ArrayList<>();
    }

    public int getIdProfesional() {
        return idProfesional;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public boolean isActivo() {
        return activo;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public List<FichaMedica> getFichasMedicas() {
        return fichasMedicas;
    }
}
