package cl.cummins.mgdi.exeption.service;

import cl.cummins.mgdi.model.TipoInyeccion;
import cl.cummins.mgdi.repository.ITipoInyeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoInyeccionService implements ICRUDService<TipoInyeccion> {

    @Autowired
    private ITipoInyeccionRepository tipoInyeccionRepo;

    @Override
    public List<TipoInyeccion> findAll() {
        return tipoInyeccionRepo.findAll();
    }

    @Override
    public Optional<TipoInyeccion> findById(Long id) {
        return tipoInyeccionRepo.findById(id);
    }

    @Override
    public TipoInyeccion create(TipoInyeccion tipoInyeccion) {
        return tipoInyeccionRepo.save(tipoInyeccion);
    }

    @Override
    public TipoInyeccion update(TipoInyeccion tipoInyeccion) {
        return tipoInyeccionRepo.save(tipoInyeccion);
    }

    @Override
    public void delete(Long id) {
        tipoInyeccionRepo.deleteById(id);
    }
}
