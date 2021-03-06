package cl.cummins.mgdi.service;

import cl.cummins.mgdi.model.PermisosUsuario;
import cl.cummins.mgdi.repository.IPermisosUsuarioRepository;
import cl.cummins.mgdi.service.ICRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermisosUsuarioService implements ICRUDService<PermisosUsuario> {

    @Autowired
    private IPermisosUsuarioRepository pemisoRepo;

    @Override
    public List<PermisosUsuario> findAll() {
        return pemisoRepo.findAll();
    }

    @Override
    public Optional<PermisosUsuario> findById(Long id) {
        return pemisoRepo.findById(id);
    }

    @Override
    public PermisosUsuario create(PermisosUsuario permisosUsuario) {
        return pemisoRepo.save(permisosUsuario);
    }

    @Override
    public PermisosUsuario update(PermisosUsuario permisosUsuario) {
        return pemisoRepo.save(permisosUsuario);
    }

    @Override
    public void delete(Long id) {
        pemisoRepo.deleteById(id);
    }
}
