package io.ultimatesoftware.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "egresoreciennacido",catalog = "sghc",schema = "public")
public class EgresoRecienNacido {
    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;
    private LocalDate fechaEgresoRn;
    private String estadoRn;
    private String alimento;
    private Integer pesoEgresoRn;
    private String responsableEgresoRn;
    private LocalDate fechaEgresoMaterno;
    private String responsableEgresoMaterno;
    private String anticoncepcion;
    private String estadoMaterno;
    @ManyToOne(optional = false)
    @JoinColumn(name = "recieNacidoid")
    private RecienNacido recienNacido;

    public EgresoRecienNacido() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    public String getEstadoRn() {
        return estadoRn;
    }

    public void setEstadoRn(String estadoRn) {
        this.estadoRn = estadoRn;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    public Integer getPesoEgresoRn() {
        return pesoEgresoRn;
    }

    public void setPesoEgresoRn(Integer pesoEgresoRn) {
        this.pesoEgresoRn = pesoEgresoRn;
    }

    public String getResponsableEgresoRn() {
        return responsableEgresoRn;
    }

    public void setResponsableEgresoRn(String responsableEgresoRn) {
        this.responsableEgresoRn = responsableEgresoRn;
    }

    public LocalDate getFechaEgresoRn() {
        return fechaEgresoRn;
    }

    public void setFechaEgresoRn(LocalDate fechaEgresoRn) {
        this.fechaEgresoRn = fechaEgresoRn;
    }

    public LocalDate getFechaEgresoMaterno() {
        return fechaEgresoMaterno;
    }

    public void setFechaEgresoMaterno(LocalDate fechaEgresoMaterno) {
        this.fechaEgresoMaterno = fechaEgresoMaterno;
    }

    public String getResponsableEgresoMaterno() {
        return responsableEgresoMaterno;
    }

    public void setResponsableEgresoMaterno(String responsableEgresoMaterno) {
        this.responsableEgresoMaterno = responsableEgresoMaterno;
    }

    public String getAnticoncepcion() {
        return anticoncepcion;
    }

    public void setAnticoncepcion(String anticoncepcion) {
        this.anticoncepcion = anticoncepcion;
    }

    public String getEstadoMaterno() {
        return estadoMaterno;
    }

    public void setEstadoMaterno(String estadoMaterno) {
        this.estadoMaterno = estadoMaterno;
    }

    public RecienNacido getRecienNacido() {
        return recienNacido;
    }

    public void setRecienNacido(RecienNacido recienNacido) {
        this.recienNacido = recienNacido;
    }
}
