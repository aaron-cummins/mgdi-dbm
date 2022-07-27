package cl.cummins.mgdi.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="tipo_inyeccion")
@Data
public class TipoInyeccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementTipoInyeccion")
    @GenericGenerator(name = "incrementTipoInyeccion", strategy = "increment")
    public Long id;

    private String nombre;

    private Boolean activo;

    @OneToMany(mappedBy = "tipoInyeccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VersionMotor> versionMotors = new LinkedHashSet<>();

}
