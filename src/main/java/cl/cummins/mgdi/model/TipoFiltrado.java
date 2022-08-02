package cl.cummins.mgdi.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="tipo_filtrado")
@Data
public class TipoFiltrado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementTipoFiltrado")
    public Long id;

    private String nombre;

    private Boolean activo;

    @OneToMany(mappedBy = "tipoFiltrado", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VersionMotor> versionMotors = new LinkedHashSet<>();

  }
