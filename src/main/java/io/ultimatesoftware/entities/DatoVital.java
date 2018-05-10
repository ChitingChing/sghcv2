/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ultimatesoftware.entities;


import java.util.Collection;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author chiti
 */
@Entity
@Table(name = "datovital", catalog = "sghc", schema = "public")

public class DatoVital {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id",columnDefinition = "uuid")
    private UUID id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "unidad")
    private String unidad;
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datoVital")
    private Collection<DatoVitalConsulta> datoVitalConsultaCollection;

    public DatoVital() {
    }

    public DatoVital(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Collection<DatoVitalConsulta> getDatoVitalConsultaCollection() {
        return datoVitalConsultaCollection;
    }

    public void setDatoVitalConsultaCollection(Collection<DatoVitalConsulta> datoVitalConsultaCollection) {
        this.datoVitalConsultaCollection = datoVitalConsultaCollection;
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
        if (!(object instanceof DatoVital)) {
            return false;
        }
        DatoVital other = (DatoVital) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.ultimatesoftware.entities.DatoVital[ id=" + id + " ]";
    }
    
}
