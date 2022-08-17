package cl.cummins.mgdi.model;


import lombok.Data;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementComuna")
    public Long id;

    @NotBlank(message = "El nombre es obligatorio") @Size(min = 3, max = 250, message = "El nombre debe ser un valor entre 3 y 250 caracteres")
    @Column(length = 250)
    public String nombre;

    @Column(name = "region_id")
    private Long regionId;

    @Column()
    public boolean activo;
}
