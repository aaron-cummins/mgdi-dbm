package cl.cummins.mgdi.repository;

import cl.cummins.mgdi.model.VersionMotor;
import cl.cummins.mgdi.model.Zona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IZonaRepository extends JpaRepository<Zona, Long> {
}