package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="vistas_group")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VistasGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementVistas-group")
    public Long id;

    @Column(length = 250)
    public String nombre;

    @OneToMany()
    @JoinColumn(name = "id_grupo", insertable = false, updatable = false)
    @JsonManagedReference
    @JsonIgnore
    public List<Vistas> vistas;

    public Long id_modulo;

}
