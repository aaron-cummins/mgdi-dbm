package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import cl.cummins.mgdi.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermisosUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementPermisosUsuario")
    public Long id;

    @Column(name = "id_lugar_trabajo")
    public Integer lugarTrabajo;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    public Roles roles;

    /*@ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "permisos_usuario_version_motors",
            joinColumns = @JoinColumn(name = "permisos_usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "version_motors_id"))
    private Set<VersionMotor> versionMotors = new LinkedHashSet<>();*/

    //@ManyToOne
    @JoinColumn(name = "usuario_id")
    public Long usuarioId;


}
