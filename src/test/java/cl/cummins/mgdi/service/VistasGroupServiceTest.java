package cl.cummins.mgdi.service;

import cl.cummins.mgdi.exeption.service.VistasGroupService;
import cl.cummins.mgdi.model.VistasGroup;
import cl.cummins.mgdi.repository.IVistasGroupRepository;
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
class VistasGroupServiceTest {

    @Mock
    private IVistasGroupRepository vistasGroupRepository;

    @InjectMocks
    private VistasGroupService vistasGroupService;

    private VistasGroup vistasGroup = new VistasGroup(
            1L,
            "Adminstracion",
            null,
            1L);

    @Test
    void smoke_Test(){
        assertNotNull(vistasGroupService);
    }

    @Test
    void findAll() {
        vistasGroupService.findAll();
        verify(vistasGroupRepository).findAll();
    }

    @Test
    void findById() {
        vistasGroupRepository.findById(vistasGroup.getId());
        verify(vistasGroupRepository).findById(vistasGroup.getId());
    }

    @Test
    void create() {
        vistasGroupService.create(vistasGroup);
        verify(vistasGroupRepository).save(vistasGroup);
    }

    @Test
    void update() {
        ArgumentCaptor<VistasGroup> argumentCaptor = ArgumentCaptor.forClass(VistasGroup.class);
        VistasGroup vistasGroupDTO = vistasGroupService.update(vistasGroup);
        verify(vistasGroupRepository, times(1)).save(argumentCaptor.capture());
        VistasGroup savedVistasGroup = argumentCaptor.getValue();
        assertEquals(vistasGroup.getNombre(), savedVistasGroup.getNombre());
    }

    @Test
    void delete_VistasGroupNotFound_Test() {
        vistasGroupService.delete(vistasGroup.getId());
        verify(vistasGroupRepository, times(1)).deleteById(vistasGroup.getId());
    }

    @Test
    void delete_VistasGroupFound_Test() {
        vistasGroupService.create(vistasGroup);
        vistasGroupService.delete(vistasGroup.getId());
        verify(vistasGroupRepository, times(1)).deleteById(vistasGroup.getId());
    }
}