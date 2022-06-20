package cl.cummins.mgdi.service.Vistas;

import cl.cummins.mgdi.model.Vistas;

import java.util.List;
import java.util.Optional;

public interface IVistasService {

    List<Vistas> findAll();

    Optional<Vistas> findById(Long id);

    Vistas create(Vistas vistas);

    Vistas update(Vistas vistas);

    void delete(Long id);

}
