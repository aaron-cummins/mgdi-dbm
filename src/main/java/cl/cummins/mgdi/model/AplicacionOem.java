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
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AplicacionOem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementAplicacionOem")
    public Long id;

    private String nombre;

    private boolean activo;

  }
