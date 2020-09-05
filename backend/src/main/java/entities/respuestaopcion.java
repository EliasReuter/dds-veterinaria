package entities;
import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "respuestaopcion")
public class respuestaopcion {
    @Id
    int idRespuestaOpcion;
    @ManyToOne
    @JoinColumn(name = "idRespuesta", referencedColumnName = "idRespuesta")
    int idRespuesta;
    @ManyToOne
    @JoinColumn(name = "idOpcion", referencedColumnName = "idOpcion")
    int idOpcion;
}
