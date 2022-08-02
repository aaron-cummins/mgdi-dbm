package cl.cummins.mgdi.service;

import cl.cummins.mgdi.model.TipoAdmision;
import cl.cummins.mgdi.repository.ITipoAdmisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoAdmisionService implements ICRUDService<TipoAdmision> {

    @Autowired
    private ITipoAdmisionRepository tipoAdmisionRepo;

    @Override
    public List<TipoAdmision> findAll() {
        return tipoAdmisionRepo.findAll();
    }

    @Override
    public Optional<TipoAdmision> findById(Long id) {
        return tipoAdmisionRepo.findById(id);
    }

    @Override
    public TipoAdmision create(TipoAdmision tipoAdmision) {
        return tipoAdmisionRepo.save(tipoAdmision);
    }

    @Override
    public TipoAdmision update(TipoAdmision tipoAdmision) {
        return tipoAdmisionRepo.save(tipoAdmision);
    }

    @Override
    public void delete(Long id) {
        tipoAdmisionRepo.deleteById(id);
    }
}
