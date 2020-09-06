package domain.entities;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "tipopregunta")
public class TipoPregunta {
    @Id
    @GeneratedValue
    private int idTipoPregunta;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "tipopregunta", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Pregunta> preguntas;

    public TipoPregunta() {
        this.preguntas = new ArrayList<>();
    }

    public int getIdTipoPregunta() {
        return idTipoPregunta;
    }

    public void setIdTipoPregunta(int idTipoPregunta) {
        this.idTipoPregunta = idTipoPregunta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
}
