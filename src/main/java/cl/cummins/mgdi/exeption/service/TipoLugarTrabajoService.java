package cl.cummins.mgdi.exeption.service;

import cl.cummins.mgdi.model.TipoLugarTrabajo;
import cl.cummins.mgdi.repository.ITipoLugarTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoLugarTrabajoService implements ICRUDService<TipoLugarTrabajo> {

    @Autowired
    private ITipoLugarTrabajoRepository tipoLugarTrabajoRepo;

    @Override
    public List<TipoLugarTrabajo> findAll() {
        return tipoLugarTrabajoRepo.findAll();
    }

    @Override
    public Optional<TipoLugarTrabajo> findById(Long id) {
        return tipoLugarTrabajoRepo.findById(id);
    }

    @Override
    public TipoLugarTrabajo create(TipoLugarTrabajo tipoLugarTrabajo) {
        return tipoLugarTrabajoRepo.save(tipoLugarTrabajo);
    }

    @Override
    public TipoLugarTrabajo update(TipoLugarTrabajo tipoLugarTrabajo) {
        return tipoLugarTrabajoRepo.save(tipoLugarTrabajo);
    }

    @Override
    public void delete(Long id) {
        tipoLugarTrabajoRepo.deleteById(id);
    }
}
