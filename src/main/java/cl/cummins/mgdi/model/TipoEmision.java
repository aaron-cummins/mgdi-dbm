package cl.cummins.mgdi.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="tipo_emision")
@Data
public class TipoEmision {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementTipoEmision")
    @GenericGenerator(name = "incrementTipoEmisiones", strategy = "increment")
    public Long id;

    private String nombre;

    private Boolean activo;

    @OneToMany(mappedBy = "tipoEmision", orphanRemoval = true)
    private Set<VersionMotor> versionMotors = new LinkedHashSet<>();

}
