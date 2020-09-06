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
    private List<Pregunta> idPreguntas;

    public TipoPregunta() {
        this.idPreguntas = new ArrayList<>();
    }

    public int getIdTipoPregunta() {
        return idTipoPregunta;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pregunta> getIdPregunta() {
        return idPreguntas;
    }
}
