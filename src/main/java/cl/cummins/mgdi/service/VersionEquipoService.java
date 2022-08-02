package cl.cummins.mgdi.service;

import cl.cummins.mgdi.model.VersionEquipo;
import cl.cummins.mgdi.repository.IVersionEquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VersionEquipoService implements ICRUDService<VersionEquipo> {

    @Autowired
    private IVersionEquipoRepository versionEquipoRepo;

    @Override
    public List<VersionEquipo> findAll() {
        return versionEquipoRepo.findAll();
    }

    @Override
    public Optional<VersionEquipo> findById(Long id) {
        return versionEquipoRepo.findById(id);
    }

    @Override
    public VersionEquipo create(VersionEquipo versionEquipo) {
        return versionEquipoRepo.save(versionEquipo);
    }

    @Override
    public VersionEquipo update(VersionEquipo versionEquipo) {
        return versionEquipoRepo.save(versionEquipo);
    }

    @Override
    public void delete(Long id) {
        versionEquipoRepo.deleteById(id);
    }
}
