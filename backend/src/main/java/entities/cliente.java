package entities;

import javax.persistence.*;
import java.util.List;

public class cliente {
    @Id
    int idCliente;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "apellido")
    String apellido;
    @Column(name = "dni")
    int dni;
    @OneToMany(mappedBy = "mascota")
    List<mascota> mascotas;
    @ManyToOne
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    int idEmpresa;
}
