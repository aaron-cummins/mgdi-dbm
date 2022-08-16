package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="vistas_group")
@Data
public class VistasGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementVistas-group")
    public Long id;

    @Column(length = 250)
    public String nombre;

    @OneToMany()
    @JoinColumn(name = "id_grupo")
    @JsonManagedReference
    @JsonIgnore
    public List<Vistas> vistas;

    /*@JsonIgnore
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference*/
    public Long id_modulo;

}
