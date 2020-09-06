package domain.entities;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "respuesta")
public class Respuesta {
    @Id
    @GeneratedValue
    private int idRespuesta;
    @Column(name = "idEncuesta")
    private int idEncuesta;
    @Column(name = "respuestaLibre")
    private String respuestaLibre;
    @OneToMany(mappedBy = "respuesta", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<RespuestaOpcion> respuestaopciones;
    @ManyToOne
    @JoinColumn(name = "idEncuestaRespondida", referencedColumnName = "idEncuestaRespondida")
    private EncuestaRespondida idEncuestaRespondida;
    @ManyToOne
    @JoinColumn(name = "idPregunta", referencedColumnName = "idPregunta")
    private Pregunta idPregunta;

    public Respuesta() {
        this.respuestaopciones = new ArrayList<>();
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public int getIdEncuesta() {
        return idEncuesta;
    }

    public String getRespuestaLibre() {
        return respuestaLibre;
    }

    public List<RespuestaOpcion> getRespuestaopciones() {
        return respuestaopciones;
    }

    public EncuestaRespondida getIdEncuestaRespondida() {
        return idEncuestaRespondida;
    }

    public Pregunta getIdPregunta() {
        return idPregunta;
    }
}
