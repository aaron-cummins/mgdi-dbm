package cl.cummins.mgdi.model;

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

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "lugar_trabajo_id", nullable = false)
    private LugarTrabajo lugarTrabajo;

    @OneToMany(mappedBy = "flotas", orphanRemoval = true)
    private Set<Unidad> unidads = new LinkedHashSet<>();


//    public LugarTrabajo getLugarTrabajo() {
//        return lugarTrabajo;
//    }
//
//    public void setLugarTrabajo(LugarTrabajo lugarTrabajo) {
//        this.lugarTrabajo = lugarTrabajo;
//    }
}
