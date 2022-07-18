package cl.cummins.mgdi.service;

import cl.cummins.mgdi.model.Roles;
import cl.cummins.mgdi.repository.IRolesRepository;
import cl.cummins.mgdi.service.ICRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService implements ICRUDService<Roles> {

    @Autowired
    private IRolesRepository rolesRepo;

    @Override
    public List<Roles> findAll() {
        return rolesRepo.findAll();
    }

    @Override
    public Optional<Roles> findById(Long id) {
        return rolesRepo.findById(id);
    }

    @Override
    public Roles create(Roles roles) {
        return rolesRepo.save(roles);
    }

    @Override
    public Roles update(Roles roles) {
        return rolesRepo.save(roles);
    }

    @Override
    public void delete(Long id) {
        rolesRepo.deleteById(id);
    }
}
