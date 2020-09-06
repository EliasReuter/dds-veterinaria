package domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "turno")
public class Turno {
    @Id
    @GeneratedValue
    private int idTurno;
    @Column(name="activo")
    private boolean activo;
    @Column(name="cantHoras")
    private int cantHoras;
    @ManyToOne
    @JoinColumn(name = "idProfesional", referencedColumnName = "idProfesional")
    private Profesional profesional;
    @ManyToOne
    @JoinColumn(name = "idEstablecimiento", referencedColumnName = "idEstablecimiento")
    private Establecimiento establecimiento;

    public Turno() {
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }
}
