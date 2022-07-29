package cl.cummins.mgdi.repository;

import cl.cummins.mgdi.model.TipoAdmision;
import cl.cummins.mgdi.model.TipoLugarTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoAdmisionRepository extends JpaRepository<TipoAdmision, Long> {
}
