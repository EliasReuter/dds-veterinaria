package entities;
import java.sql.Date;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "opcion")
public class opcion {
    @Id
    int idOpcion;
    @Column(name = "descripcion")
    String descripcion;
    @Column(name = "activo")
    boolean activo;
    @Column(name = "fechaAlta")
    Date fechaAlta;
    @Column(name = "fechaBaja")
    Date fechaBaja;
    @OneToMany(mappedBy = "opcion")
    List<respuestaopcion> respuestaopciones;
    @ManyToOne
    @JoinColumn(name = "idPregunta", referencedColumnName = "idPregunta")
    int idPregunta;
}
