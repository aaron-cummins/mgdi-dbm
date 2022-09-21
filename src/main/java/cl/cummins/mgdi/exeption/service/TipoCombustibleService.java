package cl.cummins.mgdi.exeption.service;

import cl.cummins.mgdi.model.TipoCombustible;
import cl.cummins.mgdi.repository.ITipoCombustibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoCombustibleService implements ICRUDService<TipoCombustible> {

    @Autowired
    private ITipoCombustibleRepository tipoCombustibleRepo;

    @Override
    public List<TipoCombustible> findAll() {
        return tipoCombustibleRepo.findAll();
    }

    @Override
    public Optional<TipoCombustible> findById(Long id) {
        return tipoCombustibleRepo.findById(id);
    }

    @Override
    public TipoCombustible create(TipoCombustible tipoCombustible) {
        return tipoCombustibleRepo.save(tipoCombustible);
    }

    @Override
    public TipoCombustible update(TipoCombustible tipoCombustible) {
        return tipoCombustibleRepo.save(tipoCombustible);
    }

    @Override
    public void delete(Long id) {
        tipoCombustibleRepo.deleteById(id);
    }
}
