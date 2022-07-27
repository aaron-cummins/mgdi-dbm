package cl.cummins.mgdi.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="version_motor")
@Data
public class VersionMotor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementAplicacion")
    @GenericGenerator(name = "incrementAplicacion", strategy = "increment")
    public Long id;

    @Column(name="nombre_comercial")
    private String nombreComercial;

    @Column(name="nombre_servicio")
    private String nombreServicio;

    private Boolean ecmquantum;

    private Boolean ecmcence;

    private Boolean activo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "motor_id")
    private Motor motor;

    @ManyToMany
    @JoinTable(name = "version_motor_tipo_admisions",
            joinColumns = @JoinColumn(name = "version_motor_null"),
            inverseJoinColumns = @JoinColumn(name = "tipo_admisions_id"))
    private Set<TipoAdmision> tipoAdmisions = new LinkedHashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "modulo_control_id")
    private ModuloControl moduloControl;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_combustible_id")
    private TipoCombustible tipoCombustible;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_emision_id")
    private TipoEmision tipoEmision;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_filtrado_id")
    private TipoFiltrado tipoFiltrado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_inyeccion_id")
    private TipoInyeccion tipoInyeccion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "posttratamiento_id")
    private Posttratamiento posttratamiento;


    @ManyToMany(mappedBy = "versionMotors", cascade = CascadeType.PERSIST)
    private Set<PermisosUsuario> permisosUsuarios = new LinkedHashSet<>();


}
