package cl.cummins.mgdi.service;

import cl.cummins.mgdi.model.Region;
import cl.cummins.mgdi.repository.IRegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService implements ICRUDSevice<Region>{

    @Autowired
    private IRegionRepository regionRepo;

    @Override
    public List<Region> findAll() {
        return regionRepo.findAll();
    }

    @Override
    public Optional<Region> findById(Long id) {
        return regionRepo.findById(id);
    }

    @Override
    public Region create(Region region) {
        return regionRepo.save(region);
    }

    @Override
    public Region update(Region region) {
        return regionRepo.save(region);
    }

    @Override
    public void delete(Long id) {
        regionRepo.deleteById(id);
    }
}
