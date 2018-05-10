package io.ultimatesoftware.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "patologia", catalog = "sghc", schema = "public")
public class Patologia {
    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;
    private String descripcion;
    private String grupo;
}
