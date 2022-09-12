package cl.cummins.mgdi.repository;

import cl.cummins.mgdi.model.Comuna;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class IComunaRepositoryTest {

    @Autowired
    private IComunaRepository comunaRepository;

    @Test
    void smoke_Test(){
        assertThat(comunaRepository).isNotNull();
    }

    @Test
    void saveNullComuna_Test(){
        Comuna comuna = new Comuna();
        assertThrows(ConstraintViolationException.class,() ->{comunaRepository.save(comuna);});
    }


}