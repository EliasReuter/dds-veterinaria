package domain.entities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "pregunta")
public class Pregunta {
    @Id
    @GeneratedValue
    private int idPregunta;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "activo")
    private boolean activo;
    @Column(name = "fechaAlta")
    private LocalDate fechaAlta;
    @Column(name = "fechaBaja")
    private LocalDate fechaBaja;
    @OneToMany(mappedBy = "pregunta", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Opcion> opciones;
    @OneToMany(mappedBy = "pregunta", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Respuesta> respuestas;
    @ManyToOne
    @JoinColumn(name = "idEncuesta", referencedColumnName = "idEncuesta")
    private Encuesta encuesta;
    @ManyToOne
    @JoinColumn(name = "idTipoPregunta", referencedColumnName = "idTipoPregunta")
    private TipoPregunta tipopregunta;

    public Pregunta() {
        this.respuestas = new ArrayList<>();
        this.opciones = new ArrayList<>();
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public List<Opcion> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<Opcion> opciones) {
        this.opciones = opciones;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    public TipoPregunta getTipoPregunta() {
        return tipopregunta;
    }

    public void setTipoPregunta(TipoPregunta tipoPregunta) {
        this.tipopregunta = tipoPregunta;
    }
}
