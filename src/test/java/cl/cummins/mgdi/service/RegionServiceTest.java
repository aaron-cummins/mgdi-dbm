package cl.cummins.mgdi.service;

import cl.cummins.mgdi.exeption.service.RegionService;
import cl.cummins.mgdi.model.Region;
import cl.cummins.mgdi.repository.IRegionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegionServiceTest {
    @Mock
    private IRegionRepository regionRepository;

    @InjectMocks
    private RegionService regionService;

    private Region region = new Region(1L,
            "XIII",
            "Region Metropolitana",
            null,
            true);

    @Test
    void smoke_Test(){
        assertThat(regionService).isNotNull();
    }
    @Test
    void findAll() {
        regionService.findAll();
        verify(regionRepository).findAll();
    }

    @Test
    void findById() {
        regionService.findById(1L);
        verify(regionRepository).findById(1L);
    }

    @Test
    void create() {
        regionService.create(region);
        verify(regionRepository).save(region);
    }

    @Test
    void update() {
        ArgumentCaptor<Region>regionArgumentCaptor = ArgumentCaptor.forClass(Region.class);

        Region regionDTO = regionService.update(region);
        verify(regionRepository, times(1)).save(regionArgumentCaptor.capture());
        Region regionSaved = regionArgumentCaptor.getValue();
        assertEquals(regionSaved.getNumero(), region.getNumero());
    }

    @Test
    void deleteRegion_NotPresent_Test() {
        regionService.delete(region.getId());
        verify(regionRepository, times(1)).deleteById(region.getId());
    }

    @Test
    void deleteRegion_Present_Test(){
        regionService.create(region);
        regionService.delete(region.getId());
        verify(regionRepository).deleteById(region.getId());
    }
}