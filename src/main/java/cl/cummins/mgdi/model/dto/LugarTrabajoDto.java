package cl.cummins.mgdi.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LugarTrabajoDto implements Serializable {
    private final Long id;
    private final String nombre;
    private final String direccion;
    private final String telefono;
}
