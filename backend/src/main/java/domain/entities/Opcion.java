package domain.entities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "opcion")
public class Opcion {
    @Id
    @GeneratedValue
    private int idOpcion;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "activo")
    private boolean activo;
    @Column(name = "fechaAlta")
    private LocalDate fechaAlta;
    @Column(name = "fechaBaja")
    private LocalDate fechaBaja;
    @OneToMany(mappedBy = "opcion", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<RespuestaOpcion> respuestaopciones;
    @ManyToOne
    @JoinColumn(name = "idPregunta", referencedColumnName = "idPregunta")
    private Pregunta pregunta;

    public Opcion() {
        this.respuestaopciones = new ArrayList<>();
    }

    public int getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(int idOpcion) {
        this.idOpcion = idOpcion;
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

    public List<RespuestaOpcion> getRespuestaopciones() {
        return respuestaopciones;
    }

    public void setRespuestaopciones(List<RespuestaOpcion> respuestaopciones) {
        this.respuestaopciones = respuestaopciones;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
}
