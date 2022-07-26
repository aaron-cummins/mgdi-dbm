package cl.cummins.mgdi.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class UsuarioDto implements Serializable {
    private final Long id;
    private final String rut;
    private final String uid;
    private final String nombres;
    private final String apellidos;
    private final String correo;
    private final String telefono;
    private final String anexo;
    private final CargoDto cargo;
    private final Set<PermisosUsuarioDto> permisos;
    private final boolean activo;
}
