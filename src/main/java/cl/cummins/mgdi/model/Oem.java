package cl.cummins.mgdi.model;

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


    @OneToMany(mappedBy = "oem", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Equipo> equipos = new LinkedHashSet<>();

}
