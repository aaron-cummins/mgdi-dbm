package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import cl.cummins.mgdi.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="permisos_globales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermisosGlobales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementPermisosGlobales")
    public Long id;

    @Column(name = "rol_id")
    public Long rolId;

    @Column(name="modulo_id")
    public Long moduloId;

}
