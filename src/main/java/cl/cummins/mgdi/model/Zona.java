package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "zona")
@Data
public class Zona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementZona")
    @GenericGenerator(name = "incrementZona", strategy = "increment")
    public Long id;

    public String nombre;

    private boolean activo;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Pais pais;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "zona_id")
    private List<LugarTrabajo> lugarTrabajos;
}
