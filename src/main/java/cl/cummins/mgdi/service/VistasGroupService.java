package cl.cummins.mgdi.service;

import cl.cummins.mgdi.model.Vistas;
import cl.cummins.mgdi.model.VistasGroup;
import cl.cummins.mgdi.repository.IVistasGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VistasGroupService implements ICRUDService<VistasGroup> {

    @Autowired
    private IVistasGroupRepository vistaRepo;

    @Override
    public List<VistasGroup> findAll() {
        return vistaRepo.findAll();
    }

    @Override
    public Optional<VistasGroup> findById(Long id) {
        return vistaRepo.findById(id);
    }

    @Override
    public VistasGroup create(VistasGroup vistas) {
        return vistaRepo.save(vistas);
    }

    @Override
    public VistasGroup update(VistasGroup vistas) {
        return vistaRepo.save(vistas);
    }

    @Override
    public void delete(Long id) {
        vistaRepo.deleteById(id);
    }
}
