package cl.cummins.mgdi.exeption.service;

import cl.cummins.mgdi.model.Aplicacion;

import cl.cummins.mgdi.repository.IAplicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AplicacionService implements ICRUDService<Aplicacion> {

    @Autowired
    private IAplicacionRepository aplicacionRepo;

    @Override
    public List<Aplicacion> findAll() {
        return aplicacionRepo.findAll();
    }

    @Override
    public Optional<Aplicacion> findById(Long id) {
        return aplicacionRepo.findById(id);
    }

    @Override
    public Aplicacion create(Aplicacion aplicacion) {
        return aplicacionRepo.save(aplicacion);
    }

    @Override
    public Aplicacion update(Aplicacion aplicacion) {
        return aplicacionRepo.save(aplicacion);
    }

    @Override
    public void delete(Long id) {
        aplicacionRepo.deleteById(id);
    }
}
