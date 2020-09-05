package entities;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "empresa")
public class empresa {

    @Id
    int idEmpresa;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "cuit")
    int cuit;
    @OneToMany(mappedBy = "empresa")
    List<encuesta> encuestas;
    @OneToMany(mappedBy = "empresa")
    List<establecimiento> establecimientos;
    @OneToMany(mappedBy = "empresa")
    List<cliente> cliente;
    @OneToMany(mappedBy = "empresa")
    List<fichaMedica> fichasMedicas;
}
