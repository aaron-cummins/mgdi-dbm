package cl.cummins.mgdi.service;

import cl.cummins.mgdi.model.Unidad;
import cl.cummins.mgdi.repository.IUnidadRepository;
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
class UnidadServiceTest {
    @Mock
    private IUnidadRepository unidadRepository;

    @InjectMocks
    private UnidadService unidadService;

    private Unidad unidad = new Unidad(
            1L,
            "CA-102",
            "A324567",
            null,
            null,
            true,
            null,
            null,
            null);

    @Test
    void smoke_Test(){
        assertNotNull(unidadService);
    }

    @Test
    void findAll() {
        unidadService.findAll();
        verify(unidadRepository).findAll();
    }

    @Test
    void findById() {
        unidadService.findById(unidad.getId());
        verify(unidadRepository).findById(unidad.getId());
    }

    @Test
    void create() {
        unidadService.create(unidad);
        verify(unidadRepository).save(unidad);
    }

    @Test
    void update() {
        ArgumentCaptor<Unidad> argumentCaptor = ArgumentCaptor.forClass(Unidad.class);
        Unidad unidadDTO = unidadService.update(unidad);
        verify(unidadRepository, times(1)).save(argumentCaptor.capture());
        Unidad savedUnidad = argumentCaptor.getValue();
        assertEquals(unidad.getNombre(), savedUnidad.getNombre());
    }

    @Test
    void delete() {
        unidadService.create(unidad);
        unidadService.delete(unidad.getId());
        verify(unidadRepository).deleteById(unidad.getId());
    }
}