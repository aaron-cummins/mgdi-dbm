package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.Aplicacion;
import cl.cummins.mgdi.repository.IAplicacionRepository;
import cl.cummins.mgdi.exeption.service.AplicacionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
//@ActiveProfiles("test")
class AplicacionControllerTest {

    @Autowired
    private AplicacionService aplicacionService;

    @MockBean
    private IAplicacionRepository aplicacionRepository;

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
    void createEmptyAplicacion_Test(){
        Aplicacion aplicacion = new Aplicacion();
        Set<ConstraintViolation<Aplicacion>> constraintViolation =
                validator.validate(aplicacion);
        assertEquals(2, constraintViolation.size());
    }

    @Test
    void createEmptyId_Test(){
        Aplicacion aplicacion = new Aplicacion();
        aplicacion.setNombre("Camion");
        Set<ConstraintViolation<Aplicacion>> constraintViolation =
                validator.validate(aplicacion);
        assertEquals(1, constraintViolation.size());
    }

    @Test
    void createBlankNombre_Test(){
        Aplicacion aplicacion = new Aplicacion();
        aplicacion.setId(1L);
        Set<ConstraintViolation<Aplicacion>> constraintViolation =
                validator.validate(aplicacion);
        assertEquals(1, constraintViolation.size());
    }

    @Test
    void findAll() {

    }

    @Test
    void findById() {

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