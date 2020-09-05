package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profesional")
public class profesional {
    @Id
    int idProfesional;
    @Column(name = "matricula")
    int matricula;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "apellido")
    String apellido;
    @Column(name = "activo")
    boolean activo;
    @OneToMany(mappedBy = "profesional")
    List<turno> turnos;
    @OneToMany(mappedBy = "profesional")
    List<fichaMedica> fichasMedicas;
}
