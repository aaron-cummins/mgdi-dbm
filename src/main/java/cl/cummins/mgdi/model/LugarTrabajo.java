package cl.cummins.mgdi.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="lugar_trabajo")
@Data
public class LugarTrabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementLugarTrabajo")
    @GenericGenerator(name = "incrementLugarTrabajo", strategy = "increment")
    public Long id;

    @Column(nullable = false, length = 255)
    private String nombre;

    private String direccion;

    private String telefono;

    @ManyToOne(fetch = FetchType.LAZY)
    private TipoLugarTrabajo tipoLugarTrabajo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Comuna comuna;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

}
