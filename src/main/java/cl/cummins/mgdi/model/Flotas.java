package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="flotas")
@Data
public class Flotas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementFlotas")
    public Long id;

    public String nombre;

    public boolean activo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lugar_trabajo_id", referencedColumnName = "id")
    private LugarTrabajo lugarTrabajo;

    @JsonIgnore
    @OneToMany(mappedBy = "flotas")
    private Set<Unidad> unidades;


}
