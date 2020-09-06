package domain.entities;
import java.time.LocalDate;
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
    private LocalDate fechaAlta;
    @Column(name = "fechaBaja")
    private LocalDate fechaBaja;
    @ManyToOne
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    private Empresa empresa;
    @OneToMany(mappedBy = "encuesta", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<EncuestaRespondida> encuestarespondidas;
    @OneToMany(mappedBy = "encuesta", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Pregunta> preguntas;

    public Encuesta() {
        this.preguntas = new ArrayList<>();
        this.encuestarespondidas = new ArrayList<>();
    }

    public int getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(int idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<EncuestaRespondida> getEncuestaRespondidas() {
        return encuestarespondidas;
    }

    public void setEncuestaRespondidas(List<EncuestaRespondida> encuestaRespondidas) {
        this.encuestarespondidas = encuestaRespondidas;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
}
