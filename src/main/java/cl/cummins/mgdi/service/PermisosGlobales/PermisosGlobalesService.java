package cl.cummins.mgdi.service.PermisosGlobales;

import cl.cummins.mgdi.model.PermisosGlobales;
import cl.cummins.mgdi.repository.IPermisosGlobalesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermisosGlobalesService implements IPermisosGlobalesService {

    private IPermisosGlobalesRepository permisoRepo;

    @Override
    public List<PermisosGlobales> findAll() {
        return permisoRepo.findAll();
    }

    @Override
    public Optional<PermisosGlobales> findById(Long id) {
        return permisoRepo.findById(id);
    }

    @Override
    public PermisosGlobales create(PermisosGlobales permisosGlobales) {
        return permisoRepo.save(permisosGlobales);
    }

    @Override
    public PermisosGlobales update(PermisosGlobales permisosGlobales) {
        return permisoRepo.save(permisosGlobales);
    }

    @Override
    public void delete(Long id) {
        permisoRepo.deleteById(id);
    }
}
