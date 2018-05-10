package io.ultimatesoftware.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "trabajoparto",catalog = "sghc",schema = "public")
public class TrabajoParto {
    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;
    private LocalDate fechaHora;
    private String hora;
    private String tensionArterial;
    private Integer contracciones;
    private String altura;
    private String posicion;
    private Integer fcf;
    private Integer dilatacion;
    private String meconio;
    private String nombreExaminador;
    @ManyToOne(optional = false)
    @JoinColumn(name = "admisionporpartoid")
    private AdmisionPorParto admisionPorParto;

    public TrabajoParto() {
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getTensionArterial() {
        return tensionArterial;
    }

    public void setTensionArterial(String tensionArterial) {
        this.tensionArterial = tensionArterial;
    }

    public Integer getContracciones() {
        return contracciones;
    }

    public void setContracciones(Integer contracciones) {
        this.contracciones = contracciones;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Integer getFcf() {
        return fcf;
    }

    public void setFcf(Integer fcf) {
        this.fcf = fcf;
    }

    public Integer getDilatacion() {
        return dilatacion;
    }

    public void setDilatacion(Integer dilatacion) {
        this.dilatacion = dilatacion;
    }

    public String getMeconio() {
        return meconio;
    }

    public void setMeconio(String meconio) {
        this.meconio = meconio;
    }

    public String getNombreExaminador() {
        return nombreExaminador;
    }

    public void setNombreExaminador(String nombreExaminador) {
        this.nombreExaminador = nombreExaminador;
    }

    public AdmisionPorParto getAdmisionPorParto() {
        return admisionPorParto;
    }

    public void setAdmisionPorParto(AdmisionPorParto admisionPorParto) {
        this.admisionPorParto = admisionPorParto;
    }
}
