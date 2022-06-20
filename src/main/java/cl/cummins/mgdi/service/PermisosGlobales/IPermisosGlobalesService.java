package cl.cummins.mgdi.service.PermisosGlobales;

import cl.cummins.mgdi.model.PermisosGlobales;

import java.util.List;
import java.util.Optional;

public interface IPermisosGlobalesService {

    List<PermisosGlobales> findAll();

    Optional<PermisosGlobales> findById(Long id);

    PermisosGlobales create(PermisosGlobales permisosGlobales);

    PermisosGlobales update(PermisosGlobales permisosGlobales);

    void delete(Long id);
}
