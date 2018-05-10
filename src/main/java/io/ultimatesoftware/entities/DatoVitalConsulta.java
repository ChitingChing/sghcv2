/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ultimatesoftware.entities;


import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author chiti
 */
@Entity
@Table(name = "datovitalconsulta", catalog = "sghc", schema = "public")

public class DatoVitalConsulta {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id",columnDefinition = "uuid")
    private UUID id;
    @Column(name = "valor")
    private String valor;
    @Column(name = "estado")
    private Character estado;
    @ManyToOne(optional = false)
    @JoinColumn(name = "consultaid")
    private Consulta consulta;
    @ManyToOne(optional = false)
    @JoinColumn(name = "datovitalid")
    private DatoVital datoVital;

    public DatoVitalConsulta() {
    }

    public DatoVitalConsulta(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public DatoVital getDatoVitalId() {
        return datoVital;
    }

    public void setDatoVitalId(DatoVital datoVitalId) {
        this.datoVital = datoVitalId;
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
        if (!(object instanceof DatoVitalConsulta)) {
            return false;
        }
        DatoVitalConsulta other = (DatoVitalConsulta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.ultimatesoftware.entities.DatoVitalConsulta[ id=" + id + " ]";
    }
    
}
