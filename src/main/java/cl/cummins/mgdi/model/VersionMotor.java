package cl.cummins.mgdi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="version_motor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VersionMotor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementVersionMotor")
    public Long id;

    @Column(name="nombre_comercial")
    private String nombreComercial;

    @Column(name="nombre_servicio")
    private String nombreServicio;

    private Boolean ecmquantum;

    private Boolean ecmcence;

    private Boolean activo;

    @Column(name = "motor_id")
    private Long motorId;

//    @ManyToMany
//    @JoinTable(name = "version_motor_tipo_admisions",
//            joinColumns = @JoinColumn(name = "version_motor_null"),
//            inverseJoinColumns = @JoinColumn(name = "tipo_admisions_id"))
//    private Set<TipoAdmision> tipoAdmisions = new LinkedHashSet<>();

    @Column(name = "modulo_control_id")
    private Long moduloControlId;

    @Column(name = "tipo_combustible_id")
    private Long tipoCombustibleId;

    @Column(name = "tipo_emision_id")
    private Long tipoEmisionId;

    @Column(name = "tipo_filtrado_id")
    private Long tipoFiltradoId;

    @Column(name = "tipo_inyeccion_id")
    private Long tipoInyeccionId;

    @Column(name = "posttratamiento_id")
    private Long postTratamientoId;


   /*@ManyToMany(mappedBy = "versionMotors", cascade = CascadeType.PERSIST)
    private Set<PermisosUsuario> permisosUsuarios = new LinkedHashSet<>();¨*/


}
