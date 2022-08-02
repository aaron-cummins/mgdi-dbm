package cl.cummins.mgdi.repository;

import cl.cummins.mgdi.model.Comuna;
import cl.cummins.mgdi.model.Flotas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlotasRepository extends JpaRepository<Flotas, Long> {
}
