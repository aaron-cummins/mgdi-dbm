package cl.cummins.mgdi.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PermisosUsuarioDto implements Serializable {
    private final Long id;
    private final Integer lugarTrabajo;
    private final Integer versionMotor;
}
