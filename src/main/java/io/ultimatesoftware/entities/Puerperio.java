package io.ultimatesoftware.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "puerperio",catalog = "sghc",schema = "public")
public class Puerperio {
    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;
    private LocalDate fechaPostParto;
    private String horaPostParto;
    private Float temperatura;
    private String pulso;
    private String presionArterial;
    private String uterina;
    private String caracteristicasLoquios;
    @ManyToOne(optional = false)
    @JoinColumn(name = "embarazoid")
    private Embarazo embarazo;

    public Puerperio() {
    }

    public String getHoraPostParto() {
        return horaPostParto;
    }

    public void setHoraPostParto(String horaPostParto) {
        this.horaPostParto = horaPostParto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getFechaPostParto() {
        return fechaPostParto;
    }

    public void setFechaPostParto(LocalDate fechaPostParto) {
        this.fechaPostParto = fechaPostParto;
    }

    public Float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Float temperatura) {
        this.temperatura = temperatura;
    }

    public String getPulso() {
        return pulso;
    }

    public void setPulso(String pulso) {
        this.pulso = pulso;
    }

    public String getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(String presionArterial) {
        this.presionArterial = presionArterial;
    }

    public String getUterina() {
        return uterina;
    }

    public void setUterina(String uterina) {
        this.uterina = uterina;
    }

    public String getCaracteristicasLoquios() {
        return caracteristicasLoquios;
    }

    public void setCaracteristicasLoquios(String caracteristicasLoquios) {
        this.caracteristicasLoquios = caracteristicasLoquios;
    }

    public Embarazo getEmbarazo() {
        return embarazo;
    }

    public void setEmbarazo(Embarazo embarazo) {
        this.embarazo = embarazo;
    }
}
