package cl.cummins.mgdi.service;

import cl.cummins.mgdi.model.Vistas;
import cl.cummins.mgdi.repository.IVistasRepository;
import cl.cummins.mgdi.service.ICRUDSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VistasService implements ICRUDSevice<Vistas> {

    @Autowired
    private IVistasRepository vistaRepo;

    @Override
    public List<Vistas> findAll() {
        return vistaRepo.findAll();
    }

    @Override
    public Optional<Vistas> findById(Long id) {
        return vistaRepo.findById(id);
    }

    @Override
    public Vistas create(Vistas vistas) {
        return vistaRepo.save(vistas);
    }

    @Override
    public Vistas update(Vistas vistas) {
        return vistaRepo.save(vistas);
    }

    @Override
    public void delete(Long id) {
        vistaRepo.deleteById(id);
    }
}
