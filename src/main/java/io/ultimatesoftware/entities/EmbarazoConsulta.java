package io.ultimatesoftware.entities;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "embarazoconsulta",catalog = "sghc", schema = "public")
public class EmbarazoConsulta {
    @Id
    @Column(name = "id",columnDefinition = "uuid")
    private UUID id;
    private LocalDate fecha;
    private Integer semanasAmenorreas;
    private BigDecimal peso;
    private String presionArterial;
    private Integer alturaUterina;
    private String presentacion;
    private String fcf;
    private String movFetal;
    private String edema;
    private String albuminuria;
    private String sangradoGenital;
    private String nombreExaminador;
    @ManyToOne//(optional = false)
    @JoinColumn(name = "embarazoid")
    private Embarazo embarazo;

    public EmbarazoConsulta() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getSemanasAmenorreas() {
        return semanasAmenorreas;
    }

    public void setSemanasAmenorreas(Integer semanasAmenorreas) {
        this.semanasAmenorreas = semanasAmenorreas;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(String presionArterial) {
        this.presionArterial = presionArterial;
    }

    public Integer getAlturaUterina() {
        return alturaUterina;
    }

    public void setAlturaUterina(Integer alturaUterina) {
        this.alturaUterina = alturaUterina;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getFcf() {
        return fcf;
    }

    public void setFcf(String fcf) {
        this.fcf = fcf;
    }

    public String getMovFetal() {
        return movFetal;
    }

    public void setMovFetal(String movFetal) {
        this.movFetal = movFetal;
    }

    public String getEdema() {
        return edema;
    }

    public void setEdema(String edema) {
        this.edema = edema;
    }

    public String getAlbuminuria() {
        return albuminuria;
    }

    public void setAlbuminuria(String albuminuria) {
        this.albuminuria = albuminuria;
    }

    public String getSangradoGenital() {
        return sangradoGenital;
    }

    public void setSangradoGenital(String sangradoGenital) {
        this.sangradoGenital = sangradoGenital;
    }

    public String getNombreExaminador() {
        return nombreExaminador;
    }

    public void setNombreExaminador(String nombreExaminador) {
        this.nombreExaminador = nombreExaminador;
    }

    public Embarazo getEmbarazo() {
        return embarazo;
    }

    public void setEmbarazo(Embarazo embarazo) {
        this.embarazo = embarazo;
    }
}
