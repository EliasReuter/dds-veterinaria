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
    private List<FichaMedica> fichasmedicas;

    public Profesional() {
        this.fichasmedicas = new ArrayList<>();
        this.turnos = new ArrayList<>();
    }

    public int getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(int idProfesional) {
        this.idProfesional = idProfesional;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public List<FichaMedica> getFichasMedicas() {
        return fichasmedicas;
    }

    public void setFichasMedicas(List<FichaMedica> fichasMedicas) {
        this.fichasmedicas = fichasMedicas;
    }
}
