package cl.cummins.mgdi.service;

import cl.cummins.mgdi.model.Vistas;
import cl.cummins.mgdi.repository.IVistasRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class VistasServiceTest {

    @Mock
    private IVistasRepository vistasRepository;

    @InjectMocks
    private VistasService vistasService;

    private Vistas vistas = new Vistas(
            1L,
            "Administracion",
            "Acceder",
            "Limpieza",
            1L,
            null,
            null);

    @Test
    void smoke_Test(){
        assertNotNull(vistasService);
    }

    @Test
    void findAll() {
        vistasService.findAll();
        verify(vistasRepository).findAll();
    }

    @Test
    void findById() {
        vistasService.findById(vistas.getId());
        verify(vistasRepository).findById(vistas.getId());
    }

    @Test
    void create() {
        vistasService.create(vistas);
        verify(vistasRepository).save(vistas);
    }

    @Test
    void update() {
        ArgumentCaptor<Vistas> argumentCaptor = ArgumentCaptor.forClass(Vistas.class);
        Vistas vistasDTO = vistasService.update(vistas);
        verify(vistasRepository).save(argumentCaptor.capture());
        Vistas savedVistas = argumentCaptor.getValue();
        assertEquals(vistas.getNombre(), savedVistas.getNombre());
    }

    @Test
    void delete_VistasNotPresent_Test() {
        vistasService.delete(vistas.getId());
        verify(vistasRepository).deleteById(vistas.getId());
    }

    @Test
    void delete_VistasPresent_Test() {
        vistasService.create(vistas);
        vistasService.delete(vistas.getId());
        verify(vistasRepository).deleteById(vistas.getId());
    }
}