package cl.cummins.mgdi.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="posttramiento")
@Data
public class Posttratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementPosttratamiento")
    @GenericGenerator(name = "incrementPosttramiento", strategy = "increment")
    public Long id;

    private String nombre;

    private Boolean activo;

    @OneToMany(mappedBy = "posttratamiento", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VersionMotor> versionMotors = new LinkedHashSet<>();


}
