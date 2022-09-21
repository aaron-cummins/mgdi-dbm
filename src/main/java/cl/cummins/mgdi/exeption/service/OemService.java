package cl.cummins.mgdi.exeption.service;

import cl.cummins.mgdi.model.Oem;
import cl.cummins.mgdi.repository.IOemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OemService implements ICRUDService<Oem> {

    @Autowired
    private IOemRepository oemRepo;

    @Override
    public List<Oem> findAll() {
        return oemRepo.findAll();
    }

    @Override
    public Optional<Oem> findById(Long id) {
        return oemRepo.findById(id);
    }

    @Override
    public Oem create(Oem oem) {
        return oemRepo.save(oem);
    }

    @Override
    public Oem update(Oem oem) {
        return oemRepo.save(oem);
    }

    @Override
    public void delete(Long id) {
        oemRepo.deleteById(id);
    }
}
