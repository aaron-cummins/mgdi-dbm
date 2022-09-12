package cl.cummins.mgdi.service;

import cl.cummins.mgdi.model.Aplicacion;
import cl.cummins.mgdi.repository.IAplicacionOemRepository;
import cl.cummins.mgdi.repository.IAplicacionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AplicacionServiceTest {

    @Mock
    private IAplicacionRepository aplicacionRepository;

    @InjectMocks
    private AplicacionService aplicacionService;

    private Aplicacion aplicacion = new Aplicacion(
        1L,
        "Camion",
        true,
        null);

    @Test
    void smoke_Test(){
        assertNotNull(aplicacionService);
    }

    @Test
    void findAll() {
        aplicacionService.findAll();
        verify(aplicacionRepository).findAll();
    }

    @Test
    void findById() {
        aplicacionService.findById(aplicacion.getId());
        verify(aplicacionRepository).findById(aplicacion.getId());
    }

    @Test
    void create() {
        aplicacionService.create(aplicacion);
        verify(aplicacionRepository).save(aplicacion);
    }

    @Test
    void update() {
        ArgumentCaptor<Aplicacion> argumentCaptor = ArgumentCaptor.forClass(Aplicacion.class);
        Aplicacion aplicacionDTO = aplicacionService.update(aplicacion);
        verify(aplicacionRepository).save(argumentCaptor.capture());
        Aplicacion savedAplicacion = argumentCaptor.getValue();
        assertEquals(aplicacion.getNombre(), savedAplicacion.getNombre());
    }

    @Test
    void delete_AplicacionNotPresent_Test() {
        aplicacionService.delete(aplicacion.getId());
        verify(aplicacionRepository).deleteById(aplicacion.getId());
    }

    @Test
    void delete_AplicacionPresent_Test() {
        aplicacionService.create(aplicacion);
        aplicacionService.delete(aplicacion.getId());
        verify(aplicacionRepository).deleteById(aplicacion.getId());
    }
}