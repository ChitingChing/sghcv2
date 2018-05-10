package io.ultimatesoftware.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "enfermedad", catalog = "sghc", schema = "public")
public class Enfermedad {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;
    private String nombre;
    private String descripcion;
    private Character estado;

    public Enfermedad(UUID id) {
        this.id = id;
    }

    public Enfermedad(UUID id, String nombre, String descripcion, Character estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
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

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }
}
