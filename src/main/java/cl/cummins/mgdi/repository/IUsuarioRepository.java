package cl.cummins.mgdi.repository;

import cl.cummins.mgdi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByCorreo(String correo);
}
