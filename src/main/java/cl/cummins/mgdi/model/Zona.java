package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "zona")
@Data
public class Zona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementZona")
    public Long id;

    public String nombre;

    private boolean activo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pais_id", referencedColumnName = "id")
    private Pais pais;

    @JsonIgnore
    @OneToMany(mappedBy = "zona")
    private List<LugarTrabajo> lugarTrabajos;
}
