package cl.cummins.mgdi.service.PermisosUsuario;

import cl.cummins.mgdi.model.PermisosUsuario;

import java.util.List;
import java.util.Optional;

public interface IPermisosUsuarioService {

    List<PermisosUsuario> findAll();

    Optional<PermisosUsuario> findById(Long id);

    PermisosUsuario create(PermisosUsuario permisosUsuario);

    PermisosUsuario update(PermisosUsuario permisosUsuario);

    void delete(Long id);
}
