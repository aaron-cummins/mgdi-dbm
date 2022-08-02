package cl.cummins.mgdi.repository;

import cl.cummins.mgdi.model.Motor;
import cl.cummins.mgdi.model.Oem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMotorRepository extends JpaRepository<Motor, Long> {
}
