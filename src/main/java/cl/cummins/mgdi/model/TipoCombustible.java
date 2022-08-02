package cl.cummins.mgdi.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="tipo_combustible")
@Data
public class TipoCombustible {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementTipoCombustible")
    @GenericGenerator(name = "incrementTipoCombustibles", strategy = "increment")
    public Long id;

    private String nombre;

    private Boolean activo;

    @OneToMany(mappedBy = "tipoCombustible", orphanRemoval = true)
    private Set<VersionMotor> versionMotors = new LinkedHashSet<>();

  }
