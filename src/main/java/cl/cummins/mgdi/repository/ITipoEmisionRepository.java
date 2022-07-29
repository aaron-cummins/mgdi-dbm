package cl.cummins.mgdi.repository;

import cl.cummins.mgdi.model.TipoAdmision;
import cl.cummins.mgdi.model.TipoEmision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoEmisionRepository extends JpaRepository<TipoEmision, Long> {
}
