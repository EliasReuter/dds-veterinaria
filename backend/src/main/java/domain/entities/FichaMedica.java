package domain.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fichaMedica")
public class FichaMedica {
    @Id
    @GeneratedValue
    private int idFichaMedica;

    @OneToOne
    @JoinColumn(name = "idEncuestaRespondida")
    private EncuestaRespondida encuestarespondida;

    @ManyToOne
    @JoinColumn(name = "idProfesional", referencedColumnName = "idProfesional")
    private Profesional profesional;

    @ManyToOne
    @JoinColumn(name = "idEstablecimiento", referencedColumnName = "idEstablecimiento")
    private Establecimiento establecimiento;

    @ManyToOne
    @JoinColumn(name = "idMascota", referencedColumnName = "idMascota")
    private Mascota mascota;

    @Column(name = "fechaCreacion", columnDefinition = "date")
    private LocalDate fechaCreacion;

    public FichaMedica() {

    }

    public int getIdFichaMedica() {
        return idFichaMedica;
    }

    public void setIdFichaMedica(int idFichaMedica) {
        this.idFichaMedica = idFichaMedica;
    }

    public EncuestaRespondida getEncuestaRespondida() {
        return encuestarespondida;
    }

    public void setEncuestaRespondida(EncuestaRespondida encuestaRespondida) {
        this.encuestarespondida = encuestaRespondida;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
