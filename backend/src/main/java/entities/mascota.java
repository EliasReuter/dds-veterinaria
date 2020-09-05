package entities;

import javax.persistence.*;
import java.util.List;

public class mascota {
    @Id
    int idMascota;
    @Column(name = "nombre")
    String nombre;

    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    int idCliente;

    @OneToMany(mappedBy = "fichaMedica")
    List<fichaMedica> fichasMedicas;

}