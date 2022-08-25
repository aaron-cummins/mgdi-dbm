package cl.cummins.mgdi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="comunas")
@Data
public class Comuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementComuna")
    public Long id;

    @NotBlank(message = "El nombre es obligatorio") @Size(min = 3, max = 250, message = "El nombre debe ser un valor entre 3 y 250 caracteres")
    @Column(length = 250)
    public String nombre;

    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    private Region region;

    @JsonIgnore
    @OneToMany(mappedBy = "comuna")
    private List<LugarTrabajo> lugarTrabajoList;


    @Column()
    public boolean activo;
}
