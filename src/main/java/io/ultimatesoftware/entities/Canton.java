package io.ultimatesoftware.entities;

import javax.persistence.*;

@Entity
@Table(name ="canton",schema = "public",catalog = "sghc")
public class Canton {
    @Id
    private String id;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "provinciaid")
    private Provincia provincia;

    public Canton() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
}