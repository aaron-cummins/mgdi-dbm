package cl.cummins.mgdi.repository;

import cl.cummins.mgdi.model.Aplicacion;
import cl.cummins.mgdi.model.AplicacionOem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAplicacionRepository extends JpaRepository<Aplicacion, Long> {
}
