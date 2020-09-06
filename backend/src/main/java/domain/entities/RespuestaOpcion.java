package domain.entities;
import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "respuestaopcion")
public class RespuestaOpcion {
    @Id
    @GeneratedValue
    private int idRespuestaOpcion;
    @ManyToOne
    @JoinColumn(name = "idRespuesta", referencedColumnName = "idRespuesta")
    private Respuesta respuesta;
    @ManyToOne
    @JoinColumn(name = "idOpcion", referencedColumnName = "idOpcion")
    private Opcion opcion;

    public RespuestaOpcion() {

    }

    public int getIdRespuestaOpcion() {
        return idRespuestaOpcion;
    }

    public void setIdRespuestaOpcion(int idRespuestaOpcion) {
        this.idRespuestaOpcion = idRespuestaOpcion;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public Opcion getOpcion() {
        return opcion;
    }

    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }
}
