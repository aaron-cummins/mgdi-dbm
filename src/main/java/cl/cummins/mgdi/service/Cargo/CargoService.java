package cl.cummins.mgdi.service.Cargo;

import cl.cummins.mgdi.model.Cargo;
import cl.cummins.mgdi.repository.ICargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService implements  ICargoService {

    @Autowired
    private ICargoRepository cargoRepo;

    @Override
    public List<Cargo> findAll() {
        return cargoRepo.findAll();
    }

    @Override
    public Optional<Cargo> findById(Long id) {
        return cargoRepo.findById(id);
    }

    @Override
    public Cargo create(Cargo cargo) {
        return cargoRepo.save(cargo);
    }

    @Override
    public Cargo update(Cargo cargo) {
        return cargoRepo.save(cargo);
    }

    @Override
    public void delete(Long id) {
        cargoRepo.deleteById(id);
    }
}
