package entities;
import java.sql.Date;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "pregunta")
public class pregunta {
    @Id
    int idPregunta;
    @Column(name = "descripcion")
    String descripcion;
    @Column(name = "activo")
    boolean activo;
    @Column(name = "fechaAlta")
    Date fechaAlta;
    @Column(name = "fechaBaja")
    Date fechaBaja;
    @OneToMany(mappedBy = "opcion")
    List<opcion> opcion;
    @OneToMany(mappedBy = "respuesta")
    List<respuesta> respuestas;
    @ManyToOne
    @JoinColumn(name = "idEncuesta", referencedColumnName = "idEncuesta")
    int idEncuesta;
    @ManyToOne
    @JoinColumn(name = "idTipoPregunta", referencedColumnName = "idTipoPregunta")
    int idTipoPregunta;
}
