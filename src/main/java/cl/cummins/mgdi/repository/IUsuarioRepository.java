package cl.cummins.mgdi.repository;

import cl.cummins.mgdi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
}
