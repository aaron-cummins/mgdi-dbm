package cl.cummins.mgdi.service.Cargo;

import cl.cummins.mgdi.model.Cargo;

import java.util.List;
import java.util.Optional;

public interface ICargoService {
    List<Cargo> findAll();

    Optional<Cargo> findById(Long id);

    Cargo create(Cargo cargo);

    Cargo update(Cargo cargo);

    void delete(Long id);
}
