package domain.entities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "encuestarespondida")
public class EncuestaRespondida {
    @Id
    @GeneratedValue
    private int idEncuestaRespondida;

    @ManyToOne
    @JoinColumn(name = "idEncuesta", referencedColumnName = "idEncuesta")
    private Encuesta encuesta;

    @Column(name = "fechaCreacion")
    private LocalDate fechacreacion;

    @OneToMany(mappedBy = "encuestarespondida", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Respuesta> respuestas;

    @OneToOne
    @JoinColumn(name = "idFichaMedica")
    private FichaMedica fichamedica;

    public EncuestaRespondida() {
        this.respuestas = new ArrayList<>();
    }

    public int getIdEncuestaRespondida() {
        return idEncuestaRespondida;
    }

    public void setIdEncuestaRespondida(int idEncuestaRespondida) {
        this.idEncuestaRespondida = idEncuestaRespondida;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    public LocalDate getFechaCreacion() {
        return fechacreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechacreacion = fechaCreacion;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public FichaMedica getFichaMedica() {
        return fichamedica;
    }

    public void setFichaMedica(FichaMedica fichaMedica) {
        this.fichamedica = fichaMedica;
    }
}
