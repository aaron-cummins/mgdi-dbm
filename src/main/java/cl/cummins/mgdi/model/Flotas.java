package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name="flotas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flotas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementFlotas")
    public Long id;

    @NotBlank
    public String nombre;

    public boolean activo;

    @Column(name = "lugar_trabajo_id")
    private Long lugarTrabajoId;

}
