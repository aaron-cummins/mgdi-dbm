package cl.cummins.mgdi.repository;

import cl.cummins.mgdi.model.VersionEquipo;
import cl.cummins.mgdi.model.VersionMotor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVersionEquipoRepository extends JpaRepository<VersionEquipo, Long> {
}