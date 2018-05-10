package io.ultimatesoftware.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "reciennacido",catalog = "sghc",schema = "public")
public class RecienNacido {
    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;
    private Character sexo;
    private Integer pesoNacer;
    private Boolean menor2500g;
    private Integer talla;
    private Integer perCefalico;
    private Integer edadPorExFisico;
    private Boolean menor37;
    private String pesoEdadGestacional;
    private Integer apgar1min;
    private Integer apgar5min;
    private String reaminRespir;
    private String vdrl;
    private String examenFisico;
    private String patologias;
    private Boolean alojConjunto;
    private Boolean hospitalizado;
    private Boolean bcg;
    private Boolean pvo;
    private String grupoSanguineo;
    private String rh;
    private String observaciones;
    @ManyToOne(optional = false)
    @JoinColumn(name = "admisionporpartoid")
    private AdmisionPorParto admisionPorParto;
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "recienNacido")
    private Collection<EgresoRecienNacido> egresoRecienNacidoCollection;

    public AdmisionPorParto getAdmisionPorParto() {
        return admisionPorParto;
    }

    public void setAdmisionPorParto(AdmisionPorParto admisionPorParto) {
        this.admisionPorParto = admisionPorParto;
    }

    public Collection<EgresoRecienNacido> getEgresoRecienNacidoCollection() {
        return egresoRecienNacidoCollection;
    }

    public void setEgresoRecienNacidoCollection(Collection<EgresoRecienNacido> egresoRecienNacidoCollection) {
        this.egresoRecienNacidoCollection = egresoRecienNacidoCollection;
    }

    public RecienNacido() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Integer getPesoNacer() {
        return pesoNacer;
    }

    public void setPesoNacer(Integer pesoNacer) {
        this.pesoNacer = pesoNacer;
    }

    public Boolean isMenor2500g() {
        return menor2500g;
    }

    public void setMenor2500g(Boolean menor2500g) {
        this.menor2500g = menor2500g;
    }

    public Integer getTalla() {
        return talla;
    }

    public void setTalla(Integer talla) {
        this.talla = talla;
    }

    public Integer getPerCefalico() {
        return perCefalico;
    }

    public void setPerCefalico(Integer perCefalico) {
        this.perCefalico = perCefalico;
    }

    public Integer getEdadPorExFisico() {
        return edadPorExFisico;
    }

    public void setEdadPorExFisico(Integer edadPorExFisico) {
        this.edadPorExFisico = edadPorExFisico;
    }

    public Boolean isMenor37() {
        return menor37;
    }

    public void setMenor37(Boolean menor37) {
        this.menor37 = menor37;
    }

    public String getPesoEdadGestacional() {
        return pesoEdadGestacional;
    }

    public void setPesoEdadGestacional(String pesoEdadGestacional) {
        this.pesoEdadGestacional = pesoEdadGestacional;
    }

    public Integer getApgar1min() {
        return apgar1min;
    }

    public void setApgar1min(Integer apgar1min) {
        this.apgar1min = apgar1min;
    }

    public Integer getApgar5min() {
        return apgar5min;
    }

    public void setApgar5min(Integer apgar5min) {
        this.apgar5min = apgar5min;
    }

    public String getReaminRespir() {
        return reaminRespir;
    }

    public void setReaminRespir(String reaminRespir) {
        this.reaminRespir = reaminRespir;
    }

    public String getVdrl() {
        return vdrl;
    }

    public void setVdrl(String vdrl) {
        this.vdrl = vdrl;
    }

    public String getExamenFisico() {
        return examenFisico;
    }

    public void setExamenFisico(String examenFisico) {
        this.examenFisico = examenFisico;
    }

    public String getPatologias() {
        return patologias;
    }

    public void setPatologias(String patologias) {
        this.patologias = patologias;
    }

    public Boolean isAlojConjunto() {
        return alojConjunto;
    }

    public void setAlojConjunto(Boolean alojConjunto) {
        this.alojConjunto = alojConjunto;
    }

    public Boolean isHospitalizado() {
        return hospitalizado;
    }

    public void setHospitalizado(Boolean hospitalizado) {
        this.hospitalizado = hospitalizado;
    }

    public Boolean isBcg() {
        return bcg;
    }

    public void setBcg(Boolean bcg) {
        this.bcg = bcg;
    }

    public Boolean isPvo() {
        return pvo;
    }

    public void setPvo(Boolean pvo) {
        this.pvo = pvo;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }


}
