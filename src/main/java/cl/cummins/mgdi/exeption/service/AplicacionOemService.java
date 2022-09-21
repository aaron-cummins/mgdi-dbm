package cl.cummins.mgdi.exeption.service;

import cl.cummins.mgdi.model.AplicacionOem;
import cl.cummins.mgdi.repository.IAplicacionOemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AplicacionOemService implements ICRUDService<AplicacionOem> {

    @Autowired
    private IAplicacionOemRepository aplicacionRepo;

    @Override
    public List<AplicacionOem> findAll() {
        return aplicacionRepo.findAll();
    }

    @Override
    public Optional<AplicacionOem> findById(Long id) {
        return aplicacionRepo.findById(id);
    }

    @Override
    public AplicacionOem create(AplicacionOem aplicacionOem) {
        return aplicacionRepo.save(aplicacionOem);
    }

    @Override
    public AplicacionOem update(AplicacionOem aplicacionOem) {
        return aplicacionRepo.save(aplicacionOem);
    }

    @Override
    public void delete(Long id) {
        aplicacionRepo.deleteById(id);
    }
}
