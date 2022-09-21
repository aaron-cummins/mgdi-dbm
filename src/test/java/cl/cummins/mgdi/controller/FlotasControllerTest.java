package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.Flotas;
import cl.cummins.mgdi.repository.IFlotasRepository;
import cl.cummins.mgdi.exeption.service.FlotasService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.ConstraintViolation;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
class FlotasControllerTest {
    @Autowired
    private FlotasService flotasService;

    @MockBean
    private IFlotasRepository flotasRepository;

    private LocalValidatorFactoryBean validator;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @BeforeEach
    public void setUp() {
        SpringConstraintValidatorFactory springConstraintValidatorFactory
                = new SpringConstraintValidatorFactory(webApplicationContext.getAutowireCapableBeanFactory());
        validator = new LocalValidatorFactoryBean();
        validator.setConstraintValidatorFactory(springConstraintValidatorFactory);
        validator.setApplicationContext(webApplicationContext);
        validator.afterPropertiesSet();
    }

    @Test
    void loadService(){
        assertThat(flotasService).isNotNull();
    }

    @Test
    void createEmptyflota_Test(){
        Flotas flota = new Flotas();
        Set<ConstraintViolation<Flotas>> constraintViolation =
                validator.validate(flota);
        assertEquals(1, constraintViolation.size());
    }

    @Test
    void createBlankNombre_Test(){
        Flotas flota = new Flotas();
        flota.setId(1L);
        Set<ConstraintViolation<Flotas>> constraintViolation =
                validator.validate(flota);
        assertEquals(1, constraintViolation.size());
    }


    @Test
    void findAllFlotas_Test() {
        when(flotasRepository.findAll())
                .thenReturn(Stream.of(
                        new Flotas(1L, "930 E", true, null, null),
                        new Flotas(2L, "930 SE", true, null, null))
                .collect(Collectors.toList()));
        assertEquals(2, flotasService.findAll().size());
    }

    @Test
    void findById_Found_Test() {
        Flotas flota = new Flotas(1L, "930 SE", true, null, null);
        when(flotasRepository.findById(1L))
                .thenReturn(Optional.of(flota));
        assertEquals( "930 SE", flotasService.findById(1L).get().getNombre());
    }

    @Test
    void findById_NotFound_Test() {
        Flotas flota = new Flotas(2L, "930 SE", true, null, null);
        when(flotasRepository.findById(2L))
                .thenReturn(Optional.of(flota));
        assertTrue(flotasService.findById(1L).isEmpty());
    }

    @Test
    void create() {
        Flotas flota = new Flotas(2L, "930 SE", true, null, null);
        when(flotasRepository.save(flota))
                .thenReturn(flota);
        assertEquals(flota, flotasService.create(flota));
    }


    @Test
    void update() {
        ArgumentCaptor<Flotas> flotaArgumentCaptor = ArgumentCaptor.forClass(Flotas.class);
        Flotas flota = new Flotas(2L, "930 SE", true, null, null);

        Flotas FlotaDTO = flotasService.update(flota);
        verify(flotasRepository, times(1)).save(flotaArgumentCaptor.capture());

        Flotas savedEntity = flotaArgumentCaptor.getValue();
        assertEquals(flota.getNombre(), savedEntity.getNombre());
    }

    @Test
    void delete() {
        Flotas flota = new Flotas(2L, "930 SE", true, null, null);
        when(flotasRepository.save(flota))
                .thenReturn(flota);
        when(flotasRepository.findById(2L))
                .thenReturn(Optional.of(flota));
        flotasRepository.deleteById(flota.getId());
        verify(flotasRepository).deleteById(flota.getId());
    }

}