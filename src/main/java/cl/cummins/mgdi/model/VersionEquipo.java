package cl.cummins.mgdi.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="version_equipo")
public class VersionEquipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementVersionEquipo")
    @GenericGenerator(name = "incrementVersionEquipo", strategy = "increment")
    public Long id;

    private String version;

    private boolean activo;



    @OneToMany(mappedBy = "versionEquipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Unidad> unidads = new LinkedHashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;



}
