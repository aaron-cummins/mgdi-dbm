package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="oem")
@Data
public class Oem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementOem")
    public Long id;

    private String nombre;

    @Column(length = 50)
    private String abreviacion;

    private boolean activo;

    @JsonIgnore
    @OneToMany(mappedBy = "oem")
    private Set<Equipo> equipos;

}
