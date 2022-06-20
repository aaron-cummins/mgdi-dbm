package cl.cummins.mgdi.repository;

import cl.cummins.mgdi.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICargoRepository extends JpaRepository<Cargo, Long> {
}
