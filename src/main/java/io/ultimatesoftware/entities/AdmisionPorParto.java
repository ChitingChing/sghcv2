package io.ultimatesoftware.entities;

import org.hibernate.boot.jaxb.internal.stax.LocalSchema;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "admisionporparto",catalog = "sghc",schema = "public")
public class AdmisionPorParto {
    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;
    private Boolean aborto;
    private String origen;
    private Integer consultaPrenatal;
    private Boolean enHospital;
    private Boolean carnet;
    private LocalDate fechaIngreso;
    private float temperatura;
    private Integer edadGestacion;
    private Boolean menor37;
    private Boolean mayor41;
    private String presentacion;
    private Boolean tamanoFetalAdecuado;
    private String inicio;
    private String membranas;
    private LocalDate fechaMembrana ;
    private String patologias;
    private String terminacion;

    private LocalDate fechaNacimiento;
    private String indicacionPrincipal;
    private String muerteIntegerraUt;
    private Boolean episiotomia;
    private Boolean desgarro;
    private Boolean alumbEspont;
    private Boolean placentaComp;
    private String medicacionParto;
    private String nivelAtencion;
    private String atendioPartoNombre;
    private String atendioPartoCargo;
    private String atendioNeonatoNombre;
    private String atendioNeonatoCargo;
    private String nombreRn;
    private Integer HcRn;
    private Boolean multiple;
    private Integer orden;
    private String patologiaspp;
    @ManyToOne(optional = false )
    @JoinColumn(name = "embarazoid")
    private Embarazo embarazo;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "admisionPorParto")
    private Collection<TrabajoParto> trabajoPartoCollection;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "admisionPorParto")
    private Collection<RecienNacido> recienNacidoCollection;

    public Collection<RecienNacido> getRecienNacidoCollection() {
        return recienNacidoCollection;
    }

    public void setRecienNacidoCollection(Collection<RecienNacido> recienNacidoCollection) {
        this.recienNacidoCollection = recienNacidoCollection;
    }

    public AdmisionPorParto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean isAborto() {
        return aborto;
    }

    public void setAborto(Boolean esParto) {
        this.aborto = esParto;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Integer getConsultaPrenatal() {
        return consultaPrenatal;
    }

    public void setConsultaPrenatal(Integer consultaPrenatal) {
        this.consultaPrenatal = consultaPrenatal;
    }

    public Boolean isEnHospital() {
        return enHospital;
    }

    public void setEnHospital(Boolean enHospital) {
        this.enHospital = enHospital;
    }

    public Boolean isCarnet() {
        return carnet;
    }

    public void setCarnet(Boolean carnet) {
        this.carnet = carnet;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public Integer getEdadGestacion() {
        return edadGestacion;
    }

    public void setEdadGestacion(Integer edadGestacion) {
        this.edadGestacion = edadGestacion;
    }

    public Boolean isMenor37() {
        return menor37;
    }

    public void setMenor37(Boolean menor37) {
        this.menor37 = menor37;
    }

    public Boolean isMayor41() {
        return mayor41;
    }

    public void setMayor41(Boolean mayor41) {
        this.mayor41 = mayor41;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public Boolean isTamanoFetalAdecuado() {
        return tamanoFetalAdecuado;
    }

    public void setTamanoFetalAdecuado(Boolean tamanoFetalAdecuado) {
        this.tamanoFetalAdecuado = tamanoFetalAdecuado;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getMembranas() {
        return membranas;
    }

    public void setMembranas(String membranas) {
        this.membranas = membranas;
    }

    public LocalDate getFechaMembrana() {
        return fechaMembrana;
    }

    public void setFechaMembrana(LocalDate fechaMembrana) {
        this.fechaMembrana = fechaMembrana;
    }

    public String getPatologias() {
        return patologias;
    }

    public void setPatologias(String patologias) {
        this.patologias = patologias;
    }

    public String getTerminacion() {
        return terminacion;
    }

    public void setTerminacion(String terminacion) {
        this.terminacion = terminacion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIndicacionPrincipal() {
        return indicacionPrincipal;
    }

    public void setIndicacionPrincipal(String indicacionPrincipal) {
        this.indicacionPrincipal = indicacionPrincipal;
    }

    public String getMuerteIntegerraUt() {
        return muerteIntegerraUt;
    }

    public void setMuerteIntegerraUt(String muerteIntegerraUt) {
        this.muerteIntegerraUt = muerteIntegerraUt;
    }

    public Boolean isEpisiotomia() {
        return episiotomia;
    }

    public void setEpisiotomia(Boolean episiotomia) {
        this.episiotomia = episiotomia;
    }

    public Boolean isDesgarro() {
        return desgarro;
    }

    public void setDesgarro(Boolean desgarro) {
        this.desgarro = desgarro;
    }

    public Boolean isAlumbEspont() {
        return alumbEspont;
    }

    public void setAlumbEspont(Boolean alumbEspont) {
        this.alumbEspont = alumbEspont;
    }

    public Boolean isPlacentaComp() {
        return placentaComp;
    }

    public void setPlacentaComp(Boolean placentaComp) {
        this.placentaComp = placentaComp;
    }

    public String getMedicacionParto() {
        return medicacionParto;
    }

    public void setMedicacionParto(String medicacionParto) {
        this.medicacionParto = medicacionParto;
    }

    public String getNivelAtencion() {
        return nivelAtencion;
    }

    public void setNivelAtencion(String nivelAtencion) {
        this.nivelAtencion = nivelAtencion;
    }

    public String getAtendioPartoNombre() {
        return atendioPartoNombre;
    }

    public void setAtendioPartoNombre(String atendioPartoNombre) {
        this.atendioPartoNombre = atendioPartoNombre;
    }

    public String getAtendioPartoCargo() {
        return atendioPartoCargo;
    }

    public void setAtendioPartoCargo(String atendioPartoCargo) {
        this.atendioPartoCargo = atendioPartoCargo;
    }

    public String getAtendioNeonatoNombre() {
        return atendioNeonatoNombre;
    }

    public void setAtendioNeonatoNombre(String atendioNeonatoNombre) {
        this.atendioNeonatoNombre = atendioNeonatoNombre;
    }

    public String getAtendioNeonatoCargo() {
        return atendioNeonatoCargo;
    }

    public void setAtendioNeonatoCargo(String atendioNeonatoCargo) {
        this.atendioNeonatoCargo = atendioNeonatoCargo;
    }

    public String getNombreRn() {
        return nombreRn;
    }

    public void setNombreRn(String nombreRn) {
        this.nombreRn = nombreRn;
    }

    public Integer getHcRn() {
        return HcRn;
    }

    public void setHcRn(Integer hcRn) {
        HcRn = hcRn;
    }

    public Boolean isMultiple() {
        return multiple;
    }

    public void setMultiple(Boolean multiple) {
        this.multiple = multiple;
    }

    public String getPatologiaspp() {
        return patologiaspp;
    }

    public void setPatologiaspp(String patologiaspp) {
        this.patologiaspp = patologiaspp;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Embarazo getEmbarazo() {
        return embarazo;
    }

    public void setEmbarazo(Embarazo embarazo) {
        this.embarazo = embarazo;
    }

    public Collection<TrabajoParto> getTrabajoPartoCollection() {
        return trabajoPartoCollection;
    }

    public void setTrabajoPartoCollection(Collection<TrabajoParto> trabajoPartoCollection) {
        this.trabajoPartoCollection = trabajoPartoCollection;
    }
}
