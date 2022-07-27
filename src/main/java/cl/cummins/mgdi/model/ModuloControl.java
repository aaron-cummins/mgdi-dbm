package cl.cummins.mgdi.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="modulo_control")
@Data
public class ModuloControl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementModuloControl")
    @GenericGenerator(name = "incrementModuloControl", strategy = "increment")
    public Long id;

    private String nombre;

    private Boolean activo;

    @OneToMany(mappedBy = "moduloControl", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VersionMotor> versionMotors = new LinkedHashSet<>();

    public Set<VersionMotor> getVersionMotors() {
        return versionMotors;
    }

    public void setVersionMotors(Set<VersionMotor> versionMotors) {
        this.versionMotors = versionMotors;
    }
}
