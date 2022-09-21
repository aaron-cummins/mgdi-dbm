package cl.cummins.mgdi.exeption.service;

import cl.cummins.mgdi.model.ModuloControl;
import cl.cummins.mgdi.repository.IModuloControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuloControlService implements ICRUDService<ModuloControl> {

    @Autowired
    private IModuloControlRepository moduloControlRepo;

    @Override
    public List<ModuloControl> findAll() {
        return moduloControlRepo.findAll();
    }

    @Override
    public Optional<ModuloControl> findById(Long id) {
        return moduloControlRepo.findById(id);
    }

    @Override
    public ModuloControl create(ModuloControl moduloControl) {
        return moduloControlRepo.save(moduloControl);
    }

    @Override
    public ModuloControl update(ModuloControl moduloControl) {
        return moduloControlRepo.save(moduloControl);
    }

    @Override
    public void delete(Long id) {
        moduloControlRepo.deleteById(id);
    }
}
