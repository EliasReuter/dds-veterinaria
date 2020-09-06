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
    @Column(name = "respuestaLibre")
    private String respuestaLibre;
    @OneToMany(mappedBy = "respuesta", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<RespuestaOpcion> respuestaopciones;
    @ManyToOne
    @JoinColumn(name = "idEncuestaRespondida", referencedColumnName = "idEncuestaRespondida")
    private EncuestaRespondida encuestarespondida;
    @ManyToOne
    @JoinColumn(name = "idPregunta", referencedColumnName = "idPregunta")
    private Pregunta pregunta;

    public Respuesta() {
        this.respuestaopciones = new ArrayList<>();
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getRespuestaLibre() {
        return respuestaLibre;
    }

    public void setRespuestaLibre(String respuestaLibre) {
        this.respuestaLibre = respuestaLibre;
    }

    public List<RespuestaOpcion> getRespuestaopciones() {
        return respuestaopciones;
    }

    public void setRespuestaopciones(List<RespuestaOpcion> respuestaopciones) {
        this.respuestaopciones = respuestaopciones;
    }

    public EncuestaRespondida getEncuestaRespondida() {
        return encuestarespondida;
    }

    public void setEncuestaRespondida(EncuestaRespondida encuestaRespondida) {
        this.encuestarespondida = encuestaRespondida;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
}
