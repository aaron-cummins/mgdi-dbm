package cl.cummins.mgdi.service;

import cl.cummins.mgdi.model.Flotas;
import cl.cummins.mgdi.repository.IFlotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlotasService implements ICRUDService<Flotas> {

    @Autowired
    private IFlotasRepository flotasRepo;

    @Override
    public List<Flotas> findAll() {
        return flotasRepo.findAll();
    }

    @Override
    public Optional<Flotas> findById(Long id) {
        return flotasRepo.findById(id);
    }

    @Override
    public Flotas create(Flotas flotas) {
        return flotasRepo.save(flotas);
    }

    @Override
    public Flotas update(Flotas flotas) {
        return flotasRepo.save(flotas);
    }

    @Override
    public void delete(Long id) {
        flotasRepo.deleteById(id);
    }
}
