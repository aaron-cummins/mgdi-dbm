package cl.cummins.mgdi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="posttratamiento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Posttratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementPosttratamiento")
    public Long id;

    private String nombre;

    private Boolean activo;

}
