package entities;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "encuestarespondida")
public class encuestarespondida {
    @Id
    int idEncuestaRespondida;

    @ManyToOne
    @JoinColumn(name = "idEncuesta", referencedColumnName = "idEncuesta")
    int idEncuesta;

    @Column(name = "fechaCreacion")
    Date fechaCreacion;

    @OneToMany(mappedBy = "encuestarespondida")
    List<respuesta> respuestas;

    @OneToOne
    @JoinColumn(name = "idFichaMedica")
    int idFichaMedica;
}
