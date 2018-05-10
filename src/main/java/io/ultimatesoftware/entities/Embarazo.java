package io.ultimatesoftware.entities;

import javafx.scene.shape.Arc;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "embarazo", catalog = "sghc", schema = "public")
public class Embarazo {
    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;
    private LocalDate fechaRegistro;
    private Integer pesoAnterior;
    private Integer talla;
    private LocalDate fum;
    private LocalDate ffp;
    private Boolean dudas;
    private Boolean antitetanicaPrevia;
    private Integer antitetanicaActual1;
    private Integer antitetanicaActual2;
    private String grupoSanguineo;
    private String rh;
    private Boolean grupoSanguineoSensibilidad;
    private Boolean fuma;
    private Integer cigarrilosPorDia;
    private Boolean hospitalizacion;
    private Boolean traslado;
    private String lugar;
    private Boolean exClinico;
    private Boolean exMamas;
    private Boolean exOdontologico;
    private Boolean pelvis;
    private Boolean papanicolao;
    private Boolean colposcopia;
    private Boolean cervix;
    private Boolean sensibilidad;
    private String vdrl;
    private LocalDate fechaVdrl;
    private Integer glucosa;
    private LocalDate fechaGlucosa;
    private Integer hb1;
    private LocalDate fechaHb1;
    private Integer hb2;
    private LocalDate fechaHb2;
    @ManyToOne(optional = false)
    @JoinColumn(name = "pacienteid")
    private Paciente paciente;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "embarazo")
    private Collection<ArchivoEmbarazo> archivoEmbarazoCollection;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "embarazo")
    private Collection<EmbarazoConsulta> embarazoConsultaCollection;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "embarazo")
    private Collection<AdmisionPorParto> partoCollection;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "embarazo")
    private Collection<Puerperio> puerperioCollection;

    public Collection<Puerperio> getPuerperioCollection() {
        return puerperioCollection;
    }

    public void setPuerperioCollection(Collection<Puerperio> puerperioCollection) {
        this.puerperioCollection = puerperioCollection;
    }

    public Collection<AdmisionPorParto> getPartoCollection() {
        return partoCollection;
    }

    public void setPartoCollection(Collection<AdmisionPorParto> partoCollection) {
        this.partoCollection = partoCollection;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Boolean isSensibilidad() {
        return sensibilidad;
    }

    public void setSensibilidad(Boolean sensibilidad) {
        this.sensibilidad = sensibilidad;
    }

    public Collection<EmbarazoConsulta> getEmbarazoConsultaCollection() {
        return embarazoConsultaCollection;
    }

    public void setEmbarazoConsultaCollection(Collection<EmbarazoConsulta> embarazoConsultaCollection) {
        this.embarazoConsultaCollection = embarazoConsultaCollection;
    }

    public Collection<ArchivoEmbarazo> getArchivoEmbarazoCollection() {
        return archivoEmbarazoCollection;
    }

    public void setArchivoEmbarazoCollection(Collection<ArchivoEmbarazo> archivoEmbarazoCollection) {
        this.archivoEmbarazoCollection = archivoEmbarazoCollection;
    }

    public Embarazo() {
    }

    public Embarazo(Paciente paciente) {
        this.paciente = paciente;
    }

    public Paciente getPaciente() {
        return paciente;
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

    public Integer getPesoAnterior() {
        return pesoAnterior;
    }

    public void setPesoAnterior(Integer pesoAnterior) {
        this.pesoAnterior = pesoAnterior;
    }

    public Integer getTalla() {
        return talla;
    }

    public void setTalla(Integer talla) {
        this.talla = talla;
    }

    public LocalDate getFum() {
        return fum;
    }

    public void setFum(LocalDate fum) {
        this.fum = fum;
    }

    public LocalDate getFfp() {
        return ffp;
    }

    public void setFfp(LocalDate ffp) {
        this.ffp = ffp;
    }

    public Boolean isDudas() {
        return dudas;
    }

    public void setDudas(Boolean dudas) {
        this.dudas = dudas;
    }

    public Boolean isAntitetanicaPrevia() {
        return antitetanicaPrevia;
    }

    public void setAntitetanicaPrevia(Boolean antitetanicaPrevia) {
        this.antitetanicaPrevia = antitetanicaPrevia;
    }

    public Integer getAntitetanicaActual1() {
        return antitetanicaActual1;
    }

    public void setAntitetanicaActual1(Integer antitetanicaActual1) {
        this.antitetanicaActual1 = antitetanicaActual1;
    }

    public Integer getAntitetanicaActual2() {
        return antitetanicaActual2;
    }

    public void setAntitetanicaActual2(Integer antitetanicaActual2) {
        this.antitetanicaActual2 = antitetanicaActual2;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public Boolean isGrupoSanguineoSensibilidad() {
        return grupoSanguineoSensibilidad;
    }

    public void setGrupoSanguineoSensibilidad(Boolean grupoSanguineoSensibilidad) {
        this.grupoSanguineoSensibilidad = grupoSanguineoSensibilidad;
    }

    public Boolean isFuma() {
        return fuma;
    }

    public void setFuma(Boolean fuma) {
        this.fuma = fuma;
    }

    public Integer getCigarrilosPorDia() {
        return cigarrilosPorDia;
    }

    public void setCigarrilosPorDia(Integer cigarrilosPorDia) {
        this.cigarrilosPorDia = cigarrilosPorDia;
    }

    public Boolean isHospitalizacion() {
        return hospitalizacion;
    }

    public void setHospitalizacion(Boolean hospitalizacion) {
        this.hospitalizacion = hospitalizacion;
    }

    public Boolean isTraslado() {
        return traslado;
    }

    public void setTraslado(Boolean traslado) {
        this.traslado = traslado;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Boolean isExClinico() {
        return exClinico;
    }

    public void setExClinico(Boolean exClinico) {
        this.exClinico = exClinico;
    }

    public Boolean isExMamas() {
        return exMamas;
    }

    public void setExMamas(Boolean exMamas) {
        this.exMamas = exMamas;
    }

    public Boolean isExOdontologico() {
        return exOdontologico;
    }

    public void setExOdontologico(Boolean exOdontologico) {
        this.exOdontologico = exOdontologico;
    }

    public Boolean isPelvis() {
        return pelvis;
    }

    public void setPelvis(Boolean pelvis) {
        this.pelvis = pelvis;
    }

    public Boolean isPapanicolao() {
        return papanicolao;
    }

    public void setPapanicolao(Boolean papanicolao) {
        this.papanicolao = papanicolao;
    }

    public Boolean isColposcopia() {
        return colposcopia;
    }

    public void setColposcopia(Boolean colposcopia) {
        this.colposcopia = colposcopia;
    }

    public Boolean isCervix() {
        return cervix;
    }

    public void setCervix(Boolean cervix) {
        this.cervix = cervix;
    }

    public String getVdrl() {
        return vdrl;
    }

    public void setVdrl(String vdrl) {
        this.vdrl = vdrl;
    }

    public LocalDate getFechaVdrl() {
        return fechaVdrl;
    }

    public void setFechaVdrl(LocalDate fechaVdrl) {
        this.fechaVdrl = fechaVdrl;
    }

    public Integer getGlucosa() {
        return glucosa;
    }

    public void setGlucosa(Integer glucosa) {
        this.glucosa = glucosa;
    }

    public LocalDate getFechaGlucosa() {
        return fechaGlucosa;
    }

    public void setFechaGlucosa(LocalDate fechaGlucosa) {
        this.fechaGlucosa = fechaGlucosa;
    }

    public Integer getHb1() {
        return hb1;
    }

    public void setHb1(Integer hb1) {
        this.hb1 = hb1;
    }

    public LocalDate getFechaHb1() {
        return fechaHb1;
    }

    public void setFechaHb1(LocalDate fechaHb1) {
        this.fechaHb1 = fechaHb1;
    }

    public Integer getHb2() {
        return hb2;
    }

    public void setHb2(Integer hb2) {
        this.hb2 = hb2;
    }

    public LocalDate getFechaHb2() {
        return fechaHb2;
    }

    public void setFechaHb2(LocalDate fechaHb2) {
        this.fechaHb2 = fechaHb2;
    }
}

