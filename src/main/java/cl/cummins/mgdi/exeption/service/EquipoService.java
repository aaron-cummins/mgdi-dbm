package cl.cummins.mgdi.exeption.service;

import cl.cummins.mgdi.model.Equipo;
import cl.cummins.mgdi.repository.IEquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService implements ICRUDService<Equipo> {

    @Autowired
    private IEquipoRepository equipoRepo;

    @Override
    public List<Equipo> findAll() {
        return equipoRepo.findAll();
    }

    @Override
    public Optional<Equipo> findById(Long id) {
        return equipoRepo.findById(id);
    }

    @Override
    public Equipo create(Equipo equipo) {
        return equipoRepo.save(equipo);
    }

    @Override
    public Equipo update(Equipo equipo) {
        return equipoRepo.save(equipo);
    }

    @Override
    public void delete(Long id) {
        equipoRepo.deleteById(id);
    }
}
