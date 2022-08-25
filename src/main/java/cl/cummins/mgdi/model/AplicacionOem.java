package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table
@Data
public class AplicacionOem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementAplicacionOem")
    public Long id;

    private String nombre;

    private boolean activo;

    @JsonIgnore
    @OneToMany(mappedBy = "aplicacionOem")
    private Set<Equipo> equipos;

  }
