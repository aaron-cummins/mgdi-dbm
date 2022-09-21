package cl.cummins.mgdi.service;

import cl.cummins.mgdi.exeption.service.ZonaService;
import cl.cummins.mgdi.model.Zona;
import cl.cummins.mgdi.repository.IZonaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class )
class ZonaServiceTest {
    @Mock
    private IZonaRepository zonaRepository;

    @InjectMocks
    private ZonaService zonaService;

    private Zona zona = new Zona(
            1L,
            "Zona Norte",
            true,
            null,
            null);

    @Test
    void smoke_Test() {
        assertNotNull(zonaService);
    }

    @Test
    void findAll() {
        zonaService.findAll();
        verify(zonaRepository).findAll();
    }

    @Test
    void findById() {
        zonaService.findById(zona.getId());
        verify(zonaRepository).findById(zona.getId());
    }

    @Test
    void create() {
        zonaService.create(zona);
        verify(zonaRepository).save(zona);
    }

    @Test
    void update() {
        ArgumentCaptor<Zona> argumentCaptor = ArgumentCaptor.forClass(Zona.class);
        Zona zonaDTO = zonaService.update(zona);
        verify(zonaRepository, times(1)).save(argumentCaptor.capture());
        Zona savedZona = argumentCaptor.getValue();
        assertEquals(savedZona.getNombre(), zona.getNombre());
    }

    @Test
    void deleteZona_NotPresent_Test() {
        zonaService.delete(zona.getId());
        verify(zonaRepository, times(0)).delete(zona);
    }

    @Test
    void deleteZona_Present_Test() {
        zonaService.create(zona);
        zonaService.delete(zona.getId());
        verify(zonaRepository, times(1)).deleteById(zona.getId());
    }
}