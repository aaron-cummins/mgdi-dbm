package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="equipo")
@Data
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementEquipo")
    public Long id;

    private String nombre;

    public boolean activo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aplicacion_oem_id", referencedColumnName = "id")
    private AplicacionOem aplicacionOem;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "oem_id", referencedColumnName = "id")
    private Oem oem;

    @JsonIgnore
    @OneToMany(mappedBy = "equipo")
    private List<VersionEquipo> versionEquipos;



}
