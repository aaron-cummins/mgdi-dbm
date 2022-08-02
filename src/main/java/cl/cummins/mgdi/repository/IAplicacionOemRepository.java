package cl.cummins.mgdi.repository;

import cl.cummins.mgdi.model.AplicacionOem;
import cl.cummins.mgdi.model.Flotas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAplicacionOemRepository extends JpaRepository<AplicacionOem, Long> {
}
