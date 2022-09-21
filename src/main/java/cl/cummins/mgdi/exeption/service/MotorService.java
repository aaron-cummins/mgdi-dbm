package cl.cummins.mgdi.exeption.service;

import cl.cummins.mgdi.model.Motor;
import cl.cummins.mgdi.repository.IMotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorService implements ICRUDService<Motor> {

    @Autowired
    private IMotorRepository motorRepo;

    @Override
    public List<Motor> findAll() {
        return motorRepo.findAll();
    }

    @Override
    public Optional<Motor> findById(Long id) {
        return motorRepo.findById(id);
    }

    @Override
    public Motor create(Motor motor) {
        return motorRepo.save(motor);
    }

    @Override
    public Motor update(Motor motor) {
        return motorRepo.save(motor);
    }

    @Override
    public void delete(Long id) {
        motorRepo.deleteById(id);
    }
}
