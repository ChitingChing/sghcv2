package io.ultimatesoftware.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name ="provincia",schema = "public",catalog = "sghc")
public class Provincia {
    @Id
    private String id;
    private String descripcion;
    @OneToMany (cascade = CascadeType.ALL,mappedBy = "provincia")
    private Collection<Canton> cantonCollection;

    public Provincia() {
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

    public Collection<Canton> getCantonCollection() {
        return cantonCollection;
    }

    public void setCantonCollection(Collection<Canton> cantonCollection) {
        this.cantonCollection = cantonCollection;
    }
}
