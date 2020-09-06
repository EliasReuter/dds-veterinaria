package domain.entities;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "establecimiento")
public class Establecimiento {
    @Id
    private int idEstablecimiento;
    @Column(name = "fechaAlta")
    private Date fechaAlta;
    @Column(name = "fechaBaja")
    private Date fechaBaja;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "activo")
    private boolean activo;
    @OneToMany(mappedBy = "establecimiento", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Turno> Turnos;
    @ManyToOne
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    private Empresa idEmpresa;

    public Establecimiento() {
        this.Turnos = new ArrayList<>();
    }

    public int getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public boolean isActivo() {
        return activo;
    }

    public List<Turno> getTurnos() {
        return Turnos;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }
}
