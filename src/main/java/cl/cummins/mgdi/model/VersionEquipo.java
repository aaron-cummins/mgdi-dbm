package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="version_equipo")
public class VersionEquipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementVersionEquipo")
    public Long id;

    private String version;

    private boolean activo;

    @JsonIgnore
    @OneToMany(mappedBy = "versionEquipo")
    private Set<Unidad> unidades;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipo_id", referencedColumnName = "id")
    private Equipo equipo;



}
