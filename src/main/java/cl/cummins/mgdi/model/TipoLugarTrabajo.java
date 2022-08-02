package cl.cummins.mgdi.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tipo_lugar_trabajo")
@Data
public class TipoLugarTrabajo{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementTipoLugarTrabajo")
    @GenericGenerator(name = "incrementTipoLugaresTrabajo", strategy = "increment")
    public Long id;

    private String tipo;

    @OneToMany(fetch = FetchType.LAZY)
    private List<LugarTrabajo> lugarTrabajos;

}
