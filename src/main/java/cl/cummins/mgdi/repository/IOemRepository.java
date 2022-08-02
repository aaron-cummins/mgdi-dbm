package cl.cummins.mgdi.repository;

import cl.cummins.mgdi.model.Oem;
import cl.cummins.mgdi.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOemRepository extends JpaRepository<Oem, Long> {
}
