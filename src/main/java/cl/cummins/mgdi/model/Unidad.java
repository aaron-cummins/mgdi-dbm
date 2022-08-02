package cl.cummins.mgdi.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="unidad")
@Data
public class Unidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementUnidad")
    @GenericGenerator(name = "incrementUnidades", strategy = "increment")
    public Long id;

    public String nombre;

    public String nserie_unidad;

    public Date fecha_activacion;

    public Date fecha_desactivacion;

    public boolean activo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lugar_trabajo_id")
    private LugarTrabajo lugarTrabajo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flotas_id")
    private Flotas flotas;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "version_equipo_id")
    private VersionEquipo versionEquipo;


}
