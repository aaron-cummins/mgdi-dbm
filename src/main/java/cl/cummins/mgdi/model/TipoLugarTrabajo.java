package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tipo_lugar_trabajo")
@Data
public class TipoLugarTrabajo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementTipoLugarTrabajo")
    public Long id;

    private String tipo;

//    @JsonIgnore
//    @OneToMany(mappedBy = "tipoLugarTrabajo")
//    private List<LugarTrabajo> lugarTrabajos;

}
