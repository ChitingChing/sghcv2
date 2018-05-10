/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ultimatesoftware.entities;


import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author chiti
 */
@Entity
@Table(name = "consulta", catalog = "sghc", schema = "public")

public class Consulta {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id",columnDefinition = "uuid")
    private UUID id;
    @Column(name = "fechaConsulta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaConsulta;
    @Column(name = "fechaInserccion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInserccion;
    @Basic(optional = false)
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consulta")
    private Collection<DatoVitalConsulta> datoVitalConsultaCollection;
    @ManyToOne(optional = false)
    @JoinColumn(name = "pacienteid")
    private Paciente paciente;

    public Consulta() {
    }

    public Consulta(UUID id) {
        this.id = id;
    }

    public Consulta(UUID id, Character estado) {
        this.id = id;
        this.estado = estado;
    }

    public Object getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public Date getFechaInserccion() {
        return fechaInserccion;
    }

    public void setFechaInserccion(Date fechaInserccion) {
        this.fechaInserccion = fechaInserccion;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.ultimatesoftware.entities.Consulta[ id=" + id + " ]";
    }
    
}
