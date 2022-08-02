package cl.cummins.mgdi.service;

import cl.cummins.mgdi.model.LugarTrabajo;
import cl.cummins.mgdi.repository.ILugarTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LugarTrabajoService implements ICRUDService<LugarTrabajo> {

    @Autowired
    private ILugarTrabajoRepository lugarTrabajoRepo;

    @Override
    public List<LugarTrabajo> findAll() {
        return lugarTrabajoRepo.findAll();
    }

    @Override
    public Optional<LugarTrabajo> findById(Long id) {
        return lugarTrabajoRepo.findById(id);
    }

    @Override
    public LugarTrabajo create(LugarTrabajo lugarTrabajo) {
        return lugarTrabajoRepo.save(lugarTrabajo);
    }

    @Override
    public LugarTrabajo update(LugarTrabajo lugarTrabajo) {
        return lugarTrabajoRepo.save(lugarTrabajo);
    }

    @Override
    public void delete(Long id) {
        lugarTrabajoRepo.deleteById(id);
    }
}
