package cl.cummins.mgdi.repository;

import cl.cummins.mgdi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCorreo(String correo);

}
