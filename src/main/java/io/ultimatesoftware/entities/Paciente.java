/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ultimatesoftware.entities;


import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import javax.persistence.*;


/**
 *
 * @author chiti
 */
@Entity
@Table(name = "paciente", catalog = "sghc", schema = "public")

public class Paciente {

    private static final long serialVersionUID = 1L;
    @Id
    @Type(type = "pg-uuid")
    @Column(name = "id",columnDefinition = "uuid")
    private UUID id;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String identificacion;
    private String telefono1;
    private String telefono2;
    private String provincia;
    private String canton;
    private String direccion;
    private String email;
    private Character sexo;
   // @Temporal(TemporalType.DATE)
    private LocalDate fechaNacimiento;
    @Basic(optional = false)
    private Character estado;
    private Date fechaAdmision;
    private Integer nHistorialClinico;
    private Boolean alfabeta;
    private String estadoCivil;
    private String estudios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Collection<Embarazo> embarazoCollection;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "paciente")
    private  Collection<Antecedente> antecedenteCollection;

    public Paciente() {
    }

    public Collection<Antecedente> getAntecedenteCollection() {
        return antecedenteCollection;
    }

    public void setAntecedenteCollection(Collection<Antecedente> antecedenteCollection) {
        this.antecedenteCollection = antecedenteCollection;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Date getFechaAdmision() {
        return fechaAdmision;
    }

    public void setFechaAdmision(Date fechaAdmision) {
        this.fechaAdmision = fechaAdmision;
    }

    public Integer getnHistorialClinico() {
        return nHistorialClinico;
    }

    public void setnHistorialClinico(Integer nHistorialClinico) {
        this.nHistorialClinico = nHistorialClinico;
    }

    public Boolean getAlfabeta() {
        return alfabeta;
    }

    public void setAlfabeta(boolean alfabeta) {
        this.alfabeta = alfabeta;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public void setAlfabeta(Boolean alfabeta) {
        this.alfabeta = alfabeta;
    }

    public Collection<Embarazo> getEmbarazoCollection() {
        return embarazoCollection;
    }

    public void setEmbarazoCollection(Collection<Embarazo> embarazoCollection) {
        this.embarazoCollection = embarazoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.ultimatesoftware.entities.Paciente[ id=" + id + " ]";
    }
    
}
