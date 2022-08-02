package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="comunas")
@Data
public class Comuna {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementComuna")
    @GenericGenerator(name = "incrementComunas", strategy = "increment")
    public Long id;

    @NotBlank(message = "El nombre es obligatorio") @Size(min = 3, max = 250, message = "El nombre debe ser un valor entre 3 y 250 caracteres")
    @Column(length = 250)
    public String nombre;

    @JsonBackReference
    @ManyToOne()
    private Region region;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)//mappedBy = "id")
    @JoinColumn(name = "comuna_id")
    private Set<LugarTrabajo> lugarTrabajo;

    @Column()
    public boolean activo;
}
