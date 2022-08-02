package cl.cummins.mgdi.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="equipo")
@Data
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementEquipo")
    @GenericGenerator(name = "incrementEquipos", strategy = "increment")
    public Long id;

    private String nombre;

    public boolean activo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aplicacion_oem_id")
    private AplicacionOem aplicacionOem;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "oem_id")
    private Oem oem;

    @OneToMany(mappedBy = "equipo", orphanRemoval = true)
    private Set<VersionEquipo> versionEquipos = new LinkedHashSet<>();



}
