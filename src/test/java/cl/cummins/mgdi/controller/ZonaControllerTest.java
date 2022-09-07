package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.Region;
import cl.cummins.mgdi.model.Zona;
import cl.cummins.mgdi.repository.IZonaRepository;
import cl.cummins.mgdi.service.ZonaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

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
//        Zona zona = new Zona(null, "Zona Norte", true, null, null );
//        Set<ConstraintViolation<Zona>> constraintViolation =
//                validator.validate(zona);
//        assertEquals(1, constraintViolation.size());
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
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}