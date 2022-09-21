package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="oem")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Oem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementOem")
    public Long id;

    private String nombre;

    @Column(length = 50)
    private String abreviacion;

    private boolean activo;


}
