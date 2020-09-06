package domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "turno")
public class Turno {
    @Id
    private int idTurno;
    @Column(name="activo")
    private boolean activo;
    @Column(name="cantHoras")
    private int cantHoras;
    @ManyToOne
    @JoinColumn(name = "idProfesional", referencedColumnName = "idProfesional")
    private Profesional idProfesional;
    @ManyToOne
    @JoinColumn(name = "idEstablecimiento", referencedColumnName = "idEstablecimiento")
    private Establecimiento idEstablecimiento;

    public Turno() {
    }

    public int getIdTurno() {
        return idTurno;
    }

    public boolean isActivo() {
        return activo;
    }

    public int getCantHoras() {
        return cantHoras;
    }

    public Profesional getIdProfesional() {
        return idProfesional;
    }

    public Establecimiento getIdEstablecimiento() {
        return idEstablecimiento;
    }
}
