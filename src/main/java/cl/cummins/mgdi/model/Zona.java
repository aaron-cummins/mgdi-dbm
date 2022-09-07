package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "zona")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Zona {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementZona")
    public Long id;

    @NotBlank
    public String nombre;

    private boolean activo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pais_id", referencedColumnName = "id")
    private Pais pais;

    @JsonIgnore
    @OneToMany(mappedBy = "zona")
    private List<LugarTrabajo> lugarTrabajos;
}
