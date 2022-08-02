package cl.cummins.mgdi.service;

import cl.cummins.mgdi.model.TipoFiltrado;
import cl.cummins.mgdi.repository.ITipoFiltradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoFiltradoService implements ICRUDService<TipoFiltrado> {

    @Autowired
    private ITipoFiltradoRepository tipoFiltradoRepo;

    @Override
    public List<TipoFiltrado> findAll() {
        return tipoFiltradoRepo.findAll();
    }

    @Override
    public Optional<TipoFiltrado> findById(Long id) {
        return tipoFiltradoRepo.findById(id);
    }

    @Override
    public TipoFiltrado create(TipoFiltrado tipoFiltrado) {
        return tipoFiltradoRepo.save(tipoFiltrado);
    }

    @Override
    public TipoFiltrado update(TipoFiltrado tipoFiltrado) {
        return tipoFiltradoRepo.save(tipoFiltrado);
    }

    @Override
    public void delete(Long id) {
        tipoFiltradoRepo.deleteById(id);
    }
}
