package domain.entities;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "pregunta")
public class Pregunta {
    @Id
    private int idPregunta;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "activo")
    private boolean activo;
    @Column(name = "fechaAlta")
    private Date fechaAlta;
    @Column(name = "fechaBaja")
    private Date fechaBaja;
    @OneToMany(mappedBy = "pregunta", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Opcion> opciones;
    @OneToMany(mappedBy = "pregunta", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Respuesta> Respuestas;
    @ManyToOne
    @JoinColumn(name = "idEncuesta", referencedColumnName = "idEncuesta")
    private Encuesta idEncuesta;
    @ManyToOne
    @JoinColumn(name = "idTipoPregunta", referencedColumnName = "idTipoPregunta")
    private TipoPregunta idTipoPregunta;

    public Pregunta() {
        this.Respuestas = new ArrayList<>();
        this.opciones = new ArrayList<>();
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public List<Opcion> getOpciones() {
        return opciones;
    }

    public List<Respuesta> getRespuestas() {
        return Respuestas;
    }

    public Encuesta getIdEncuesta() {
        return idEncuesta;
    }

    public TipoPregunta getIdTipoPregunta() {
        return idTipoPregunta;
    }
}
