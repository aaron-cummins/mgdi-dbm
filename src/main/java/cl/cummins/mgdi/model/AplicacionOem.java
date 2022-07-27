package cl.cummins.mgdi.model;

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
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementAplicacionOem")
    @GenericGenerator(name = "incrementAplicacionOem", strategy = "increment")
    public Long id;

    private String nombre;

    private boolean activo;

    @OneToMany(mappedBy = "aplicacionOem", orphanRemoval = true)
    private Set<Equipo> equipos = new LinkedHashSet<>();

  }
