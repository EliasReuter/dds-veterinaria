package entities;

import javax.persistence.*;

@Entity
@Table(name = "turno")
public class turno {
    @Id
    int idTurno;
    @Column(name="activo")
    boolean activo;
    @Column(name="cantHoras")
    int cantHoras;
    @ManyToOne
    @JoinColumn(name = "idProfesional", referencedColumnName = "idProfesional")
    int idProfesional;
    @ManyToOne
    @JoinColumn(name = "idEstablecimiento", referencedColumnName = "idEstablecimiento")
    int idEstablecimiento;

}
