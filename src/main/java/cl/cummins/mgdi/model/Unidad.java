package cl.cummins.mgdi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="unidad")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Unidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementUnidad")
    public Long id;

    public String nombre;

    @Column(name = "nserie_unidad")
    public String nserieUnidad;

    @Column(name = "fecha_activacion")
    public Date fechaActivacion;

    @Column(name="fecha_desactivacion")
    public Date fechaDesactivacion;

    public boolean activo;
    @Column(name = "lugar_trabajo_id")
    private Long lugarTrabajoId;

    @Column(name = "flotas_id")
    private Long flotasId;

    @Column(name = "version_equipo_id")
    private Long versionEquipo;


}
