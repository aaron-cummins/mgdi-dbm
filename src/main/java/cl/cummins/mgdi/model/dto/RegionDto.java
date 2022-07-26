package cl.cummins.mgdi.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class RegionDto implements Serializable {
    private final Long id;
    @NotBlank(message = "El Numero es obligatorio")
    private final String numero;
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 250, message = "El nombre debe ser un valor entre 3 y 250 caracteres")
    private final String nombre;
    private final boolean activo;
}
