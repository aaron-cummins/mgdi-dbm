package cl.cummins.mgdi.repository;

import cl.cummins.mgdi.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaisRepository extends JpaRepository<Pais, Long> {
}
