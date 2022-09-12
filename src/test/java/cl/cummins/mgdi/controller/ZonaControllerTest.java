package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.Zona;
import cl.cummins.mgdi.repository.IZonaRepository;
import cl.cummins.mgdi.service.ZonaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ZonaControllerTest {
    @Autowired
    private ZonaService zonaService;

    @MockBean
    private IZonaRepository zonaRepository;

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
   void createEmptyZona_Test(){
        Zona zona = new Zona();
        Set<ConstraintViolation<Zona>> constraintViolation =
                validator.validate(zona);
        assertEquals(1, constraintViolation.size());
    }

    @Test
    void createZonaWithIdNull_Test(){
        assertThrows(NullPointerException.class, () ->
            {new Zona(null, "Zona Norte", true, null, null );});
    }

    @Test
    void createZonaWithZonaBlank_Test(){
        Zona zona = new Zona(1L, "", true, null, null );
        Set<ConstraintViolation<Zona>> constraintViolation =
                validator.validate(zona);
        assertEquals(1, constraintViolation.size());
    }

    @Test
    void createZonaWithZonaNull_Test(){
        Zona zona = new Zona(1L, null, true, null, null );
        Set<ConstraintViolation<Zona>> constraintViolation =
                validator.validate(zona);
        assertEquals(1, constraintViolation.size());
    }
    @Test
    void findAll() {
        when(zonaRepository.findAll())
                .thenReturn((Stream.of(
                                new Zona(1L, "Zona Norte", true, null, null),
                                new Zona(2L, "Zona Sur",  true, null, null))
                        .collect(Collectors.toList())));
        assertEquals(2, zonaService.findAll().size());
    }

    @Test
    void findZoneById_Test() {
        Zona zona = new Zona(1L, "Norte", true, null, null);
        when(zonaRepository.findById(1L))
                .thenReturn(Optional.of(zona));
        assertEquals("Norte", zonaService.findById(1L).get().getNombre());
    }

    @Test
    void findRegionById_notFound_Test(){
        assertTrue(zonaService.findById(0L).isEmpty());
    }

    @Test
    void create() {
        Zona zona = new Zona(1L, "Zona Norte", true, null, null);
        when(zonaRepository.save(zona)).thenReturn(zona);
        assertEquals(zona, zonaService.create(zona));
    }

    @Test
    void update() {
        ArgumentCaptor<Zona> zonaArgumentCaptor = ArgumentCaptor.forClass(Zona.class);
        Zona zona = new Zona(1L, "Zona Norte", true, null, null);
        Zona responseDto = zonaService.update(zona);
        verify(zonaRepository, times(1)).save(zonaArgumentCaptor.capture());
        Zona savedEntity = zonaArgumentCaptor.getValue();
        assertEquals(zona.getNombre(), savedEntity.getNombre());
    }

    @Test
    void delete() {
        Zona zona = new Zona(1L, "Zona Norte", true, null, null);
        when(zonaRepository.save(zona))
                .thenReturn(zona);
        when(zonaRepository.findById(zona.getId()))
                .thenReturn(Optional.of(zona));
        zonaRepository.deleteById(zona.getId());
        verify(zonaRepository).deleteById(zona.getId());
    }
}