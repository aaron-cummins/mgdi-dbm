package cl.cummins.mgdi.repository;

import cl.cummins.mgdi.model.Equipo;
import cl.cummins.mgdi.model.Flotas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEquipoRepository extends JpaRepository<Equipo, Long> {
}
