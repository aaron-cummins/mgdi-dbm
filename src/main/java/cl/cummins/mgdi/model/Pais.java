package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pais")
@Data
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementPais")
    public Long id;

    public String nombre;

    public String abreviacion;

    public boolean activo;

    @JsonIgnore
    @OneToMany(mappedBy = "pais")
    private List<Zona> zonas;
}
