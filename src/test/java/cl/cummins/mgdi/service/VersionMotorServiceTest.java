package cl.cummins.mgdi.service;

import cl.cummins.mgdi.model.VersionMotor;
import cl.cummins.mgdi.repository.IVersionMotorRepository;
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
class VersionMotorServiceTest {
    @Mock
    private IVersionMotorRepository versionMotorRepository;

    @InjectMocks
    private VersionMotorService versionMotorService;

    private VersionMotor versionMotor = new VersionMotor(
            1L,
            "QSK 60",
            "QSK60 Tier I",
            true,
            true,
            true,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null);

    @Test
    void smoke_Test(){
        assertNotNull(versionMotorService);
    }

    @Test
    void findAll() {
        versionMotorService.findAll();
        verify(versionMotorRepository).findAll();
    }

    @Test
    void findById() {
        versionMotorService.findById(versionMotor.getId());
        verify(versionMotorRepository).findById(versionMotor.getId());
    }

    @Test
    void create() {
        versionMotorService.create(versionMotor);
        verify(versionMotorRepository).save(versionMotor);
    }

    @Test
    void update() {
        ArgumentCaptor<VersionMotor> argumentCaptor = ArgumentCaptor.forClass(VersionMotor.class);
        VersionMotor versionMotorDTO = versionMotorService.update(versionMotor);
        verify(versionMotorRepository, times(1)).save(argumentCaptor.capture());
        VersionMotor savedVersionMotor = argumentCaptor.getValue();
        assertEquals(versionMotor.getMotor(), savedVersionMotor.getMotor());
    }

    @Test
    void delete_VersionMotor_Test() {
        versionMotorService.create(versionMotor);
        versionMotorService.delete(versionMotor.getId());
        verify(versionMotorRepository).deleteById(versionMotor.getId());
    }
}