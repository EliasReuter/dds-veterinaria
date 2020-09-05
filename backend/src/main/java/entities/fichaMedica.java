package entities;
import javax.persistence.*;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Table(name = "fichaMedica")
public class fichaMedica {
    @Id
    int idFichaMedica;

    @OneToOne
    @JoinColumn(name = "idEncuestaRespondida")
    int idEncuestaRespondida;

    @ManyToOne
    @JoinColumn(name = "idProfesional", referencedColumnName = "idProfesional")
    int idProfesional;

    @ManyToOne
    @JoinColumn(name = "idEstablecimiento", referencedColumnName = "idEstablecimiento")
    int idEstablecimiento;

    @ManyToOne
    @JoinColumn(name = "idMascota", referencedColumnName = "idMascota")
    int idMascota;

    @Column(name = "descripcion")
    Date fechaCreacion;
}
