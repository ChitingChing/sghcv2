package io.ultimatesoftware.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "archivoembarazo",catalog = "sghc", schema = "public")
public class ArchivoEmbarazo {
    @Id
    @Column(name = "id",columnDefinition = "uuid")
    private UUID id;
    private String nombre;
    private String descripcion;
    private String extension;
    private Character estado;
    @ManyToOne(optional = false)
    @JoinColumn (name = "embarazoid")
    private Embarazo embarazo;

    public ArchivoEmbarazo() {
    }

    public ArchivoEmbarazo(Embarazo embarazo) {
        this.embarazo = embarazo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Embarazo getEmbarazo() {
        return embarazo;
    }

    public void setEmbarazo(Embarazo embarazo) {
        this.embarazo = embarazo;
    }
}
