package cl.cummins.mgdi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tipo_lugar_trabajo")
@Data
public class TipoLugarTrabajo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private String tipo;

    @OneToMany(fetch = FetchType.LAZY)
    private List<LugarTrabajo> lugarTrabajos;

}
