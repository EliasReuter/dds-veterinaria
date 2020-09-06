package domain.entities;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "encuestarespondida")
public class EncuestaRespondida {
    @Id
    private int idEncuestaRespondida;

    @ManyToOne
    @JoinColumn(name = "idEncuesta", referencedColumnName = "idEncuesta")
    private Encuesta idEncuesta;

    @Column(name = "fechaCreacion")
    private Date fechaCreacion;

    @OneToMany(mappedBy = "encuestarespondida", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Respuesta> Respuestas;

    @OneToOne
    @JoinColumn(name = "idFichaMedica")
    private FichaMedica idFichaMedica;

    public EncuestaRespondida() {
        this.Respuestas = new ArrayList<>();
    }

    public int getIdEncuestaRespondida() {
        return idEncuestaRespondida;
    }

    public Encuesta getIdEncuesta() {
        return idEncuesta;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public List<Respuesta> getRespuestas() {
        return Respuestas;
    }

    public FichaMedica getIdFichaMedica() {
        return idFichaMedica;
    }
}
