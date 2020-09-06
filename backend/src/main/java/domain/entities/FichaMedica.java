package domain.entities;
import javax.persistence.*;
import javax.persistence.Id;
import java.sql.Date;
import java.util.ArrayList;

@Entity
@Table(name = "fichaMedica")
public class FichaMedica {
    @Id
    private int idFichaMedica;

    @OneToOne
    @JoinColumn(name = "idEncuestaRespondida")
    private EncuestaRespondida idEncuestaRespondida;

    @ManyToOne
    @JoinColumn(name = "idProfesional", referencedColumnName = "idProfesional")
    private Profesional idProfesional;

    @ManyToOne
    @JoinColumn(name = "idEstablecimiento", referencedColumnName = "idEstablecimiento")
    private Establecimiento idEstablecimiento;

    @ManyToOne
    @JoinColumn(name = "idMascota", referencedColumnName = "idMascota")
    private Mascota idMascota;

    @Column(name = "descripcion")
    private Date fechaCreacion;

    public FichaMedica() {

    }

    public int getIdFichaMedica() {
        return idFichaMedica;
    }

    public EncuestaRespondida getIdEncuestaRespondida() {
        return idEncuestaRespondida;
    }

    public Profesional getIdProfesional() {
        return idProfesional;
    }

    public Establecimiento getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public Mascota getIdMascota() {
        return idMascota;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }
}
