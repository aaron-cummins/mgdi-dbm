package cl.cummins.mgdi.service;

import cl.cummins.mgdi.exeption.service.AplicacionOemService;
import cl.cummins.mgdi.model.AplicacionOem;
import cl.cummins.mgdi.repository.IAplicacionOemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AplicacionOemServiceTest {
    @Mock
    private IAplicacionOemRepository aplicacionOemRepository;

    @InjectMocks
    private AplicacionOemService aplicacionOemService;

    private AplicacionOem aplicacionOem = new AplicacionOem(
            1L,
            "Camion",
            true,
            null );

    @Test
    void smoke_Test(){
        assertNotNull(aplicacionOemService);
    }

    @Test
    void findAll() {
        aplicacionOemService.findAll();
        verify(aplicacionOemRepository).findAll();
    }

    @Test
    void findById() {
        aplicacionOemService.findById(aplicacionOem.getId());
        verify(aplicacionOemRepository).findById(aplicacionOem.getId());
    }

    @Test
    void create() {
        aplicacionOemService.create(aplicacionOem);
        verify(aplicacionOemRepository).save(aplicacionOem);
    }

    @Test
    void update() {
        ArgumentCaptor<AplicacionOem> argumentCaptor = ArgumentCaptor.forClass(AplicacionOem.class);
        AplicacionOem aplicacionOemDTO = aplicacionOemService.update(aplicacionOem);
        verify(aplicacionOemRepository, times(1)).save(argumentCaptor.capture());
        AplicacionOem savedAplicacionOem = argumentCaptor.getValue();
        assertEquals(aplicacionOem.getNombre(), savedAplicacionOem.getNombre());
    }

    @Test
    void delete_AplicacionOemNotPresent_ID() {
        aplicacionOemService.delete(aplicacionOem.getId());
        verify(aplicacionOemRepository).deleteById(aplicacionOem.getId());
    }

    @Test
    void delete_AplicacionOemPresent_Test() {
        aplicacionOemService.create(aplicacionOem);
        aplicacionOemService.delete(aplicacionOem.getId());
        verify(aplicacionOemRepository).deleteById(aplicacionOem.getId());
    }
}