package cl.cummins.mgdi.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="motor")
@Data
public class Motor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementMotor")
    @GenericGenerator(name = "incrementMotores", strategy = "increment")
    public Long id;

    private String nombre;

    @Column(name = "rango_potencia")
    private String rangoPotencia;

    private Boolean activo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aplicacion_id")
    private Aplicacion aplicacion;

    @OneToMany(mappedBy = "motor", orphanRemoval = true)
    private Set<VersionMotor> versionMotors = new LinkedHashSet<>();


}
