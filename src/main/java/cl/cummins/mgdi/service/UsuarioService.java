package cl.cummins.mgdi.service;

import cl.cummins.mgdi.model.Usuario;
import cl.cummins.mgdi.repository.IUsuarioRepository;
import cl.cummins.mgdi.service.ICRUDSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements ICRUDSevice<Usuario> {

    @Autowired
    private IUsuarioRepository usuarioRepo;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepo.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepo.findById(id);
    }

    @Override
    public Usuario create(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    @Override
    public void delete(Long id) {
        usuarioRepo.deleteById(id);
    }

    public Optional<Usuario> findByCorreo(String correo) { return usuarioRepo.findByCorreo(correo); }
}
