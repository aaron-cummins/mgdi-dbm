package cl.cummins.mgdi.service;

import cl.cummins.mgdi.model.Unidad;
import cl.cummins.mgdi.repository.IUnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadService implements ICRUDService<Unidad> {

    @Autowired
    private IUnidadRepository unidadRepo;

    @Override
    public List<Unidad> findAll() {
        return unidadRepo.findAll();
    }

    @Override
    public Optional<Unidad> findById(Long id) {
        return unidadRepo.findById(id);
    }

    @Override
    public Unidad create(Unidad unidad) {
        return unidadRepo.save(unidad);
    }

    @Override
    public Unidad update(Unidad unidad) {
        return unidadRepo.save(unidad);
    }

    @Override
    public void delete(Long id) {
        unidadRepo.deleteById(id);
    }
}
