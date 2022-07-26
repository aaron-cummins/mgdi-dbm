package cl.cummins.mgdi.repository;

import cl.cummins.mgdi.model.Comuna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IComunaRepository extends JpaRepository<Comuna, Long> {
}
