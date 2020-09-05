package entities;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "tipopregunta")
public class tipopregunta {
    @Id
    int idTipoPregunta;
    @Column(name = "nombre")
    String nombre;
    @OneToMany(mappedBy = "tipopregunta")
    List<pregunta> idPregunta;
}
