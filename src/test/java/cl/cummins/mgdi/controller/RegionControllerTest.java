package cl.cummins.mgdi.controller;

import cl.cummins.mgdi.model.Region;
import cl.cummins.mgdi.repository.IRegionRepository;
import cl.cummins.mgdi.service.RegionService;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class RegionControllerTest {

    @Autowired
    private RegionService regionService;

    @MockBean
    private IRegionRepository regionRepository;

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
    void createEmptyRegion() {
        Region region = new Region();
        Set<ConstraintViolation<Region>> constraintViolation =
                validator.validate(region);
        assertEquals(3, constraintViolation.size());
    }

    @Test
    void regionWithOutId_Test(){
        Region region = new Region();
        region.setNombre("Region Metropolitana");
        region.setNumero("XIII");
        Set<ConstraintViolation<Region>> constraintViolation =
                validator.validate(region);
        assertEquals(1, constraintViolation.size());
    }

    @Test
    void regionWithOutName_Test(){
        Region region = new Region();
        region.setId(1L);
        region.setNumero("XIII");
        Set<ConstraintViolation<Region>> constraintViolation =
                validator.validate(region);
        assertEquals(1, constraintViolation.size());
    }

    @Test
    void regionWithOutNumber_Test(){
        Region region = new Region();
        region.setId(1L);
        region.setNombre("region Metropolitana");
        Set<ConstraintViolation<Region>> constraintViolation =
                validator.validate(region);
        assertEquals(1, constraintViolation.size());
    }

    @Test
    void findAllRegion_Test() {
        when(regionRepository.findAll())
                .thenReturn((Stream.of(
                                new Region(1L, "XIII", "Region Metropolitana", null, true),
                                new Region(2L, "V", "Region Valparaiso", null, true),
                                new Region(3L, "X", "Region de Los Lagos", null, true))
                                        .collect(Collectors.toList())));
        assertEquals(3, regionService.findAll().size());
    }

    @Test
    void findRegionById_Test() {
        Region region = new Region(1L, "XIII", "Region Metropolitana", null, true);
        when(regionRepository.findById(1L))
                .thenReturn(Optional.of(region));
        assertEquals("XIII", regionService.findById(1L).get().getNumero());
    }

    @Test
    void findRegionById_notFound_Test(){
        assertTrue(regionService.findById(0L).isEmpty());
    }

    @Test
    void create() {
        Region region = new Region(1L, "XIII", "Region Metropolitana", null, true);
        //System.out.println(regionService.findAll());
        when(regionRepository.save(region)).thenReturn(region);
        assertEquals(region, regionService.create(region));
    }

    @Test
    void update() {
        // Arrange
        ArgumentCaptor<Region> regionArgumentCaptor = ArgumentCaptor.forClass(Region.class);
        Region region = new Region(1L, "XIII", "Region Metropolitana", null, true);

        // Act
        Region responseDto = regionService.update(region);
        verify(regionRepository, times(1)).save(regionArgumentCaptor.capture());

        // Assert
        Region savedEntity = regionArgumentCaptor.getValue();
        assertEquals(region.getNumero(), savedEntity.getNumero());
    }

    @Test
    void delete() {
        Region region = new Region(1L, "XIII", "Region Metropolitana", null, true);
        when(regionRepository.save(region))
                .thenReturn(region);
        when(regionRepository.findById(1L))
                .thenReturn(Optional.of(region));
        regionRepository.deleteById(region.getId());
        verify(regionRepository).deleteById(region.getId());
    }

}

