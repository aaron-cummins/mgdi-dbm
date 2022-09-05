package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.Comuna;
import cl.cummins.mgdi.model.LugarTrabajo;
import cl.cummins.mgdi.model.Region;
import cl.cummins.mgdi.repository.IComunaRepository;
import cl.cummins.mgdi.service.ComunaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ComunaControllerTest {

    @Autowired
    private ComunaService comunaService;

    @MockBean
    private IComunaRepository comunaRepository;

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
    void findAllComuna_Test() {
        when(comunaRepository.findAll())
                .thenReturn((Stream.of(
                        new Comuna(1L, "Providencia", new Region(), List.of(new LugarTrabajo()), true),
                        new Comuna(2L, "Las Condes", new Region(), List.of(new LugarTrabajo()),  true))
                        .collect(Collectors.toList())));
        assertEquals(2, comunaService.findAll().size());
    }

    @Test
    void findComunaById_Test() {
         Comuna comuna = new Comuna(1L, "Providencia", new Region(), List.of(new LugarTrabajo()), true);
        when(comunaRepository.findById(1L))
                .thenReturn(Optional.of(comuna));
        assertFalse(comunaService.findById(1L).isEmpty());
    }

    @Test
    void findComunaByIdNotFound_Test() {
        Optional<Comuna> comuna = comunaService.findById(0L);
        assertTrue(comuna.isEmpty());
    }

    @Test
    void createEmptyComuna_Test(){
        Comuna comuna = new Comuna();

        Set<ConstraintViolation<Comuna>> constraintViolations =
                validator.validate(comuna);
        assertEquals(3, constraintViolations.size());
    }

    @Test
    void createNotEmptyIdComuna_Test(){
        Comuna comuna = new Comuna();
        comuna.setId(1L);
        Set<ConstraintViolation<Comuna>> constraintViolations =
                validator.validate(comuna);
        System.out.println(constraintViolations);
        assertEquals(2, constraintViolations.size());
    }

    @Test
    void createEmptyNombreComuna_Test(){
        Comuna comuna = new Comuna();
        comuna.setId(1L);
        comuna.setNombre("Providencia");
        Set<ConstraintViolation<Comuna>> constraintViolations =
                validator.validate(comuna);
        System.out.println(constraintViolations);
        assertEquals(0, constraintViolations.size());
    }

    @Test
    void createBlankNombreComuna_Test(){
        Comuna comuna = new Comuna();
        comuna.setNombre("");
        comuna.setId(1L);
        Set<ConstraintViolation<Comuna>> constraintViolations =
                validator.validate(comuna);
        System.out.println(constraintViolations);
        assertEquals(2, constraintViolations.size());
    }


    @Test
    void createComuna_Test() {
        Comuna comuna = new Comuna(1L, "Providencia", new Region(), List.of(new LugarTrabajo()), true);
        when(comunaRepository.save(comuna))
                .thenReturn(comuna);
        assertEquals(comuna, comunaService.create(comuna));
    }

    @Test
    void updateComuna_Test() {
        Comuna comuna = new Comuna(1L, "Providencia", new Region(), List.of(new LugarTrabajo()), true);
        when(comunaRepository.save(comuna))
                .thenReturn(comuna);
        comuna.setNombre("Providenciaa");
        when(comunaRepository.save(comuna))
                .thenReturn(comuna);
        when(comunaRepository.findById(1L))
                .thenReturn(Optional.of(comuna));
        String comunaNombre = comunaService.findById(1L).get().getNombre();
        assertEquals("Providenciaa", comunaNombre);
    }

    @Test
    void deleteComuna_Test() {
        Comuna comuna = new Comuna(1L, "Providencia", new Region(), List.of(new LugarTrabajo()), true);
        when(comunaRepository.save(comuna))
                .thenReturn(comuna);
        when(comunaRepository.findById(1L))
                .thenReturn(Optional.of(comuna));
        comunaRepository.deleteById(comuna.getId());
        verify(comunaRepository).deleteById(comuna.getId());
    }
}