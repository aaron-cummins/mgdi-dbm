package cl.cummins.mgdi.repository;

import cl.cummins.mgdi.model.TipoCombustible;
import cl.cummins.mgdi.model.TipoFiltrado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoCombustibleRepository extends JpaRepository<TipoCombustible, Long> {

}
