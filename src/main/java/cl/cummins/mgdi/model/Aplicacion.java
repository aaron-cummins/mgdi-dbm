package cl.cummins.mgdi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="aplicacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aplicacion {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementAplicacion")
    public Long id;

    @NotBlank
    private String nombre;

    private Boolean activo;

    @OneToMany(mappedBy = "aplicacion", orphanRemoval = true)
    private Set<Motor> motors = new LinkedHashSet<>();


}
