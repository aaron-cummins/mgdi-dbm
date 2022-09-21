package cl.cummins.mgdi.exeption.service;

import cl.cummins.mgdi.model.VersionMotor;
import cl.cummins.mgdi.repository.IVersionMotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VersionMotorService implements ICRUDService<VersionMotor> {

    @Autowired
    private IVersionMotorRepository versionMotorRepo;

    @Override
    public List<VersionMotor> findAll() {
        return versionMotorRepo.findAll();
    }

    @Override
    public Optional<VersionMotor> findById(Long id) {
        return versionMotorRepo.findById(id);
    }

    @Override
    public VersionMotor create(VersionMotor versionMotor) {
        return versionMotorRepo.save(versionMotor);
    }

    @Override
    public VersionMotor update(VersionMotor versionMotor) {
        return versionMotorRepo.save(versionMotor);
    }

    @Override
    public void delete(Long id) {
        versionMotorRepo.deleteById(id);
    }
}
