package io.ultimatesoftware.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "prescripcion",catalog = "sghc",schema = "public")
public class Prescripcion {
    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;
    private Integer cantidad;
    private String detalle;
    private Character estado;
    @ManyToOne(optional = false)
    @JoinColumn(name = "medicinaid")
    private Medicina medicina;
    @ManyToOne(optional = false)
    @JoinColumn(name = "embarazoconsultaid")
    private EmbarazoConsulta embarazoConsulta;

    public Prescripcion() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Medicina getMedicina() {
        return medicina;
    }

    public void setMedicina(Medicina medicina) {
        this.medicina = medicina;
    }

    public EmbarazoConsulta getEmbarazoConsulta() {
        return embarazoConsulta;
    }

    public void setEmbarazoConsulta(EmbarazoConsulta embarazoConsulta) {
        this.embarazoConsulta = embarazoConsulta;
    }
}
