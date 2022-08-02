package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pais")
@Data
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementPais")
    @GenericGenerator(name = "incrementPaises", strategy = "increment")
    public Long id;

    public String nombre;

    public String abreviacion;

    public boolean activo;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pais_id")
    private List<Zona> zonas;
}
