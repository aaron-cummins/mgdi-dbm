package cl.cummins.mgdi.service;

import cl.cummins.mgdi.model.TipoEmision;
import cl.cummins.mgdi.repository.ITipoEmisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoEmisionService implements ICRUDService<TipoEmision> {

    @Autowired
    private ITipoEmisionRepository tipoEmisionRepo;

    @Override
    public List<TipoEmision> findAll() {
        return tipoEmisionRepo.findAll();
    }

    @Override
    public Optional<TipoEmision> findById(Long id) {
        return tipoEmisionRepo.findById(id);
    }

    @Override
    public TipoEmision create(TipoEmision tipoEmision) {
        return tipoEmisionRepo.save(tipoEmision);
    }

    @Override
    public TipoEmision update(TipoEmision tipoEmision) {
        return tipoEmisionRepo.save(tipoEmision);
    }

    @Override
    public void delete(Long id) {
        tipoEmisionRepo.deleteById(id);
    }
}
