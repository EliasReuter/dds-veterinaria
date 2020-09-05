package entities;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "respuesta")
public class respuesta {
    @Id
    int idRespuesta;
    @Column(name = "idEncuesta")
    int idEncuesta;
    @Column(name = "respuestaLibre")
    String respuestaLibre;
    @OneToMany(mappedBy = "respuesta")
    List<respuestaopcion> respuestaopciones;
    @ManyToOne
    @JoinColumn(name = "idEncuestaRespondida", referencedColumnName = "idEncuestaRespondida")
    int idEncuestaRespondida;
    @ManyToOne
    @JoinColumn(name = "idPregunta", referencedColumnName = "idPregunta")
    int idPregunta;

}
