package cl.cummins.mgdi.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ComunaDto implements Serializable {
    private final Long id;
    private final String numero;
    private final String nombre;
    private final RegionDto region;
    private final List<LugarTrabajoDto> lugarTrabajo;
    private final boolean activo;
}
