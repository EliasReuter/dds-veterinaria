package domain.entities;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "encuesta")
public class Encuesta {

    @Id
    @GeneratedValue
    private int idEncuesta;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fechaAlta")
    private Date fechaAlta;
    @Column(name = "fechaBaja")
    private Date fechaBaja;

    @ManyToOne
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    private Empresa idEmpresa;

    @OneToMany(mappedBy = "encuesta", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<EncuestaRespondida> EncuestaRespondidas;
    @OneToMany(mappedBy = "encuesta", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Pregunta> Preguntas;

    public Encuesta() {
        this.Preguntas = new ArrayList<>();
        this.EncuestaRespondidas = new ArrayList<>();
    }

    public int getIdEncuesta() {
        return idEncuesta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public List<EncuestaRespondida> getEncuestaRespondidas() {
        return EncuestaRespondidas;
    }

    public List<Pregunta> getPreguntas() {
        return Preguntas;
    }
}
