package cl.cummins.mgdi.service;

import cl.cummins.mgdi.model.Comuna;
import cl.cummins.mgdi.repository.IComunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComunaService implements ICRUDService<Comuna>{

    @Autowired
    private IComunaRepository comunaRepository;

    @Override
    public List<Comuna> findAll() {
        return comunaRepository.findAll();
    }

    @Override
    public Optional<Comuna> findById(Long id) {
        return comunaRepository.findById(id);
    }

    @Override
    public Comuna create(Comuna comuna) {
        return comunaRepository.save(comuna);
    }

    @Override
    public Comuna update(Comuna comuna) {
        return comunaRepository.save(comuna);
    }

    @Override
    public void delete(Long id) {
        Optional<Comuna> comuna = comunaRepository.findById(id);
        if (comuna.isPresent()) {
            comunaRepository.deleteById(id);
        }
    }

}
