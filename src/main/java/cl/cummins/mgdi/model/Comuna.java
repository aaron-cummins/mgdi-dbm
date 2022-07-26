package cl.cummins.mgdi.model;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank(message = "El nombre es obligatorio") @Size(min = 3, max = 250, message = "El nombre debe ser un valor entre 3 y 250 caracteres")
    @Column(length = 250)
    public String nombre;

    @ManyToOne()
    private Region region;

    @OneToMany(mappedBy = "id")
    private List<LugarTrabajo> lugarTrabajo;

    @Column()
    public boolean activo;
}
