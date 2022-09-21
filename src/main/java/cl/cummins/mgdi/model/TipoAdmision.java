package cl.cummins.mgdi.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="tipo_admision")
@Data
public class TipoAdmision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementTipoAdmision")
    public Long id;

    private String nombre;

    private Boolean activo;

//    @ManyToMany(mappedBy = "tipoAdmisions")
//    private Set<VersionMotor> versionMotors = new LinkedHashSet<>();

    }
