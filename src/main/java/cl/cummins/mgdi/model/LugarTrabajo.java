package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="lugar_trabajo")
@Data
public class LugarTrabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementLugarTrabajo")
    public Long id;

    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(length = 50)
    private String abreviacion;

    private Double longitud;

    private Double latitud;

    private Double altura;

    private String direccion;

    private String telefono;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "zona_id", referencedColumnName = "id")
    private Zona zona;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_lugar_trabajo_id", referencedColumnName ="id")
    private TipoLugarTrabajo tipoLugarTrabajo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comuna_id", referencedColumnName = "id")
    private Comuna comuna;

    @JsonIgnore
    @OneToMany(mappedBy = "lugarTrabajo")
    private List<Flotas> flotas;




}
