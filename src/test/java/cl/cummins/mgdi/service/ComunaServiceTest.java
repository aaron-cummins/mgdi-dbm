package cl.cummins.mgdi.service;

import cl.cummins.mgdi.exeption.service.ComunaService;
import cl.cummins.mgdi.model.Comuna;
import cl.cummins.mgdi.model.Region;
import cl.cummins.mgdi.repository.IComunaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ComunaServiceTest {

    @Mock
    private IComunaRepository comunaRepository;

    @InjectMocks
    private ComunaService comunaService;

    private Comuna comuna = new Comuna(
            1L,
            "Providencia",
            new Region(1L,
                    "XIII",
                    "Region Metropolitana",
                    null,
                    true),
            null,
            true);

    @Test
    void smoke_Test(){
        assertThat(comunaService).isNotNull();
    }

    @Test
    void getAllComunas(){
        comunaService.findAll();
        verify(comunaRepository).findAll();
    }

    @Test
    void getComunaById(){
        comunaService.findById(1L);
        verify(comunaRepository).findById(1L);
    }

    @Test
    void deleteComuna_NotPresent_Test(){
        comunaService.delete(1L);
        verify(comunaRepository, times(1)).findById(1L);
    }

    @Test
    void deleteComuna_Present_Test(){

        comunaService.create(comuna);
        when(comunaRepository.findById(comuna.getId()))
                .thenReturn(Optional.of(comuna));

        comunaService.delete(comuna.getId());
        verify(comunaRepository).deleteById(comuna.getId());
    }

    @Test
    void createComuna(){
        comunaService.create(comuna);
        verify(comunaRepository).save(comuna);
    }

    @Test
    void updateComuna(){
        ArgumentCaptor<Comuna> comunaArgumentCaptor = ArgumentCaptor.forClass(Comuna.class);
        Comuna comunaDTO = comunaService.update(comuna);
        verify(comunaRepository, times(1)).save(comunaArgumentCaptor.capture());
        Comuna comunaSaved = comunaArgumentCaptor.getValue();
        assertEquals(comunaSaved.getId(), comuna.getId());

    }

}