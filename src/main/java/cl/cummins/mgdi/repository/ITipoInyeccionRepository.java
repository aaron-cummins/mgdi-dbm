package cl.cummins.mgdi.repository;

import cl.cummins.mgdi.model.TipoFiltrado;
import cl.cummins.mgdi.model.TipoInyeccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoInyeccionRepository extends JpaRepository<TipoInyeccion, Long> {

}
