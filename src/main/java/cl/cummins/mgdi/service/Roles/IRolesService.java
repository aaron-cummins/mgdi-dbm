package cl.cummins.mgdi.service.Roles;

import cl.cummins.mgdi.model.Roles;

import java.util.List;
import java.util.Optional;

public interface IRolesService {

    List<Roles> findAll();

    Optional<Roles> findById(Long id);

    Roles create(Roles roles);

    Roles update(Roles roles);

    void delete(Long id);
}
