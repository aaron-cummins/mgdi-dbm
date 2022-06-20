package cl.cummins.mgdi.service.Usuario;

import cl.cummins.mgdi.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    List<Usuario> findAll();

    Optional<Usuario> findById(Long id);

    Usuario create(Usuario usuario);

    Usuario update(Usuario usuario);

    void delete(Long id);
}
