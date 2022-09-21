package cl.cummins.mgdi.exeption.service;

import cl.cummins.mgdi.model.Pais;
import cl.cummins.mgdi.repository.IPaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService implements ICRUDService<Pais> {

    @Autowired
    private IPaisRepository paisRepo;

    @Override
    public List<Pais> findAll() {
        return paisRepo.findAll();
    }

    @Override
    public Optional<Pais> findById(Long id) {
        return paisRepo.findById(id);
    }

    @Override
    public Pais create(Pais pais) {
        return paisRepo.save(pais);
    }

    @Override
    public Pais update(Pais pais) {
        return paisRepo.save(pais);
    }

    @Override
    public void delete(Long id) {
        paisRepo.deleteById(id);
    }
}
