package entities;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "encuesta")
public class encuesta {

    @Id
    int idEncuesta;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "descripcion")
    String descripcion;
    @Column(name = "fechaAlta")
    Date fechaAlta;
    @Column(name = "fechaBaja")
    Date fechaBaja;

    @ManyToOne
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    int idEmpresa;

    @OneToMany(mappedBy = "encuestarespondida")
    List<encuestarespondida> encuestarespondidas;
    @OneToMany(mappedBy = "pregunta")
    List<pregunta> preguntas;
}
