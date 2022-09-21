package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pais")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementPais")
    public Long id;

    public String nombre;

    public String abreviacion;

    public boolean activo;

}
