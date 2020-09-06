package domain.entities;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "opcion")
public class Opcion {
    @Id
    private int idOpcion;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "activo")
    private boolean activo;
    @Column(name = "fechaAlta")
    private Date fechaAlta;
    @Column(name = "fechaBaja")
    private Date fechaBaja;
    @OneToMany(mappedBy = "opcion", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<RespuestaOpcion> respuestaopciones;
    @ManyToOne
    @JoinColumn(name = "idPregunta", referencedColumnName = "idPregunta")
    private Pregunta idPregunta;

    public Opcion() {
        this.respuestaopciones = new ArrayList<>();
    }

    public int getIdOpcion() {
        return idOpcion;
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

    public List<RespuestaOpcion> getRespuestaopciones() {
        return respuestaopciones;
    }

    public Pregunta getIdPregunta() {
        return idPregunta;
    }
}
