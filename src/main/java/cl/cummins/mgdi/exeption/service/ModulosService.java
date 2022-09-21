package cl.cummins.mgdi.exeption.service;

import cl.cummins.mgdi.model.Modulos;
import cl.cummins.mgdi.repository.IModulosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModulosService implements ICRUDService<Modulos> {

    @Autowired
    private IModulosRepository modulosRepo;

    @Override
    public List<Modulos> findAll() {
        return modulosRepo.findAll();
    }

    @Override
    public Optional<Modulos> findById(Long id) {
        return modulosRepo.findById(id);
    }

    @Override
    public Modulos create(Modulos modulos) {
        return modulosRepo.save(modulos);
    }

    @Override
    public Modulos update(Modulos modulos) {
        return modulosRepo.save(modulos);
    }

    @Override
    public void delete(Long id) {
        modulosRepo.deleteById(id);
    }
}
