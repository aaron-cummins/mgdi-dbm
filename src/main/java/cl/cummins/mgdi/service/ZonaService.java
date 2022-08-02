package cl.cummins.mgdi.service;

import cl.cummins.mgdi.model.Zona;
import cl.cummins.mgdi.repository.IZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZonaService implements ICRUDService<Zona> {

    @Autowired
    private IZonaRepository zonaRepo;

    @Override
    public List<Zona> findAll() {
        return zonaRepo.findAll();
    }

    @Override
    public Optional<Zona> findById(Long id) {
        return zonaRepo.findById(id);
    }

    @Override
    public Zona create(Zona zona) {
        return zonaRepo.save(zona);
    }

    @Override
    public Zona update(Zona zona) {
        return zonaRepo.save(zona);
    }

    @Override
    public void delete(Long id) {
        zonaRepo.deleteById(id);
    }
}
