package cl.cummins.mgdi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="comunas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementComuna")
    public Long id;

    @NotBlank(message = "El nombre es obligatorio") @Size(min = 3, max = 250, message = "El nombre debe ser un valor entre 3 y 250 caracteres")
    @NotNull
    @Column(length = 250)
    public String nombre;

    @Column(name = "region_id")
    private Long regionId;

    public boolean activo;
}
