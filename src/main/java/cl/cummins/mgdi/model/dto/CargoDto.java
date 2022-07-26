package cl.cummins.mgdi.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CargoDto implements Serializable {
    private final Long id;
    private final String nombre;
    private final boolean activo;
}
