package cl.cummins.mgdi.repository;

import cl.cummins.mgdi.model.VersionMotor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IVersionMotorRepository extends JpaRepository<VersionMotor, Long> {
}