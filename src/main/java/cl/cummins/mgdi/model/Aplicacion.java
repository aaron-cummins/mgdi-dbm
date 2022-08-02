package cl.cummins.mgdi.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="aplicacion")
@Data
public class Aplicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementAplicacion")
    @GenericGenerator(name = "incrementAplicaciones", strategy = "increment")
    public Long id;

    private String nombre;

    private Boolean activo;

    @OneToMany(mappedBy = "aplicacion", orphanRemoval = true)
    private Set<Motor> motors = new LinkedHashSet<>();


}
