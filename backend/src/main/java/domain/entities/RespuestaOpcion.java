package domain.entities;
import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "respuestaopcion")
public class RespuestaOpcion {
    @Id
    private int idRespuestaOpcion;
    @ManyToOne
    @JoinColumn(name = "idRespuesta", referencedColumnName = "idRespuesta")
    private Respuesta idRespuesta;
    @ManyToOne
    @JoinColumn(name = "idOpcion", referencedColumnName = "idOpcion")
    private Opcion idOpcion;

    public RespuestaOpcion() {

    }

    public int getIdRespuestaOpcion() {
        return idRespuestaOpcion;
    }

    public Respuesta getIdRespuesta() {
        return idRespuesta;
    }

    public Opcion getIdOpcion() {
        return idOpcion;
    }
}
