package io.ultimatesoftware.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "antecedente",catalog = "sghc",schema = "public")
public class Antecedente {
    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;
    private String antecedentesFamiliares;
    private String antecedentesPersonales;
    private String antecedentesOtros;
    private Boolean ningunoOmasEmbarazos;
    private Boolean rnMenor2500;
    private Boolean gemelares ;
    private Integer gestas ;
    private Integer partos ;
    private Integer abortos ;
    private Integer vaginales ;
    private Integer cesareas ;
    private Integer nacidosVivos;
    private Integer nacidosMuertos;
    private Integer viven ;
    private Integer muertos1Semana;
    private Integer muertosmas1Semana;
    //@Temporal(TemporalType.DATE)
    private LocalDate fechaFinAnteriorEmbarazo;
    private BigDecimal rnMayorPeso;
    @ManyToOne(optional = false)
    @JoinColumn(name = "pacienteid")
    private Paciente paciente;

    public Antecedente() {
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getAntecedentesOtros() {
        return antecedentesOtros;
    }

    public void setAntecedentesOtros(String antecedentesOtros) {
        this.antecedentesOtros = antecedentesOtros;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAntecedentesFamiliares() {
        return antecedentesFamiliares;
    }

    public void setAntecedentesFamiliares(String antecedentesFamiliares) {
        this.antecedentesFamiliares = antecedentesFamiliares;
    }

    public String getAntecedentesPersonales() {
        return antecedentesPersonales;
    }

    public void setAntecedentesPersonales(String antecedentesPersonales) {
        this.antecedentesPersonales = antecedentesPersonales;
    }

    public Boolean getNingunoOmasEmbarazos() {
        return ningunoOmasEmbarazos;
    }

    public void setNingunoOmasEmbarazos(Boolean ningunoOmasEmbarazos) {
        this.ningunoOmasEmbarazos = ningunoOmasEmbarazos;
    }

    public Boolean getRnMenor2500() {
        return rnMenor2500;
    }

    public void setRnMenor2500(Boolean rnMenor2500) {
        this.rnMenor2500 = rnMenor2500;
    }

    public Boolean getGemelares() {
        return gemelares;
    }

    public void setGemelares(Boolean gemelares) {
        this.gemelares = gemelares;
    }

    public Integer getGestas() {
        return gestas;
    }

    public void setGestas(Integer gestas) {
        this.gestas = gestas;
    }

    public Integer getPartos() {
        return partos;
    }

    public void setPartos(Integer partos) {
        this.partos = partos;
    }

    public Integer getAbortos() {
        return abortos;
    }

    public void setAbortos(Integer abortos) {
        this.abortos = abortos;
    }

    public Integer getVaginales() {
        return vaginales;
    }

    public void setVaginales(Integer vaginales) {
        this.vaginales = vaginales;
    }

    public Integer getCesareas() {
        return cesareas;
    }

    public void setCesareas(Integer cesareas) {
        this.cesareas = cesareas;
    }

    public Integer getNacidosVivos() {
        return nacidosVivos;
    }

    public void setNacidosVivos(Integer nacidosVivos) {
        this.nacidosVivos = nacidosVivos;
    }

    public Integer getNacidosMuertos() {
        return nacidosMuertos;
    }

    public void setNacidosMuertos(Integer nacidosMuertos) {
        this.nacidosMuertos = nacidosMuertos;
    }

    public Integer getViven() {
        return viven;
    }

    public void setViven(Integer viven) {
        this.viven = viven;
    }

    public Integer getMuertos1Semana() {
        return muertos1Semana;
    }

    public void setMuertos1Semana(Integer muertos1Semana) {
        this.muertos1Semana = muertos1Semana;
    }

    public Integer getMuertosmas1Semana() {
        return muertosmas1Semana;
    }

    public void setMuertosmas1Semana(Integer muertosmas1Semana) {
        this.muertosmas1Semana = muertosmas1Semana;
    }

    public LocalDate getFechaFinAnteriorEmbarazo() {
        return fechaFinAnteriorEmbarazo;
    }

    public void setFechaFinAnteriorEmbarazo(LocalDate fechaFinAnteriorEmbarazo) {
        this.fechaFinAnteriorEmbarazo = fechaFinAnteriorEmbarazo;
    }

    public BigDecimal getRnMayorPeso() {
        return rnMayorPeso;
    }

    public void setRnMayorPeso(BigDecimal rnMayorPeso) {
        this.rnMayorPeso = rnMayorPeso;
    }
}
