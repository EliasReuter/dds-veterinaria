package entities;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "establecimiento")
public class establecimiento {
    @Id
    int idEstablecimiento;
    @Column(name = "fechaAlta")
    Date fechaAlta;
    @Column(name = "fechaBaja")
    Date fechaBaja;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "direccion")
    String direccion;
    @Column(name = "activo")
    boolean activo;
    @OneToMany(mappedBy = "establecimiento")
    List<turno> turnos;
    @ManyToOne
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    int idEmpresa;
}
