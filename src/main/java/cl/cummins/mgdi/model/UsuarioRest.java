package cl.cummins.mgdi.model;

import lombok.Data;

import java.util.Set;
@Data
public class UsuarioRest {

    public Long id;

    public String rut;

    public String uid;

    public String nombres;

    public String apellidos;

    public String correo;

    public String telefono;

    public String anexo;

    private Cargo cargo;

//    private Set<PermisosUsuario> permisos;

    public boolean activo;

}
