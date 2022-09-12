package cl.cummins.mgdi.repository;

import cl.cummins.mgdi.model.Cargo;
import cl.cummins.mgdi.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IUsuarioRepositoryTest {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private ICargoRepository cargoRepository;

    private Cargo cargo = new Cargo(
            1L,
            "Administrador",
            true);

    private Usuario usuario = new Usuario(
            1L,
            "12831702-3",
            "U1402612",
            "Cristian",
            "Reyes",
            "cristian.reyesf@cummins.cl",
            "985261328",
            "",
            "cristian.reyesf@cummins.cl",
            cargo,
            null,
            null,
            null,
            true);

    @BeforeEach
    void setUp(){
        cargoRepository.save(cargo);
    }

    @Test
    void smoke_Test(){
        assertNotNull(usuarioRepository);
    }

    @Test
    void findByCorreo_NotFound() {
        Optional<Usuario> savedUsuario = usuarioRepository.findByCorreo(usuario.getCorreo());
        assertTrue(savedUsuario.isEmpty());
    }

    @Test
    void findByCorreo_Found() {
        usuarioRepository.save(usuario);
        Optional<Usuario> savedUsuario = usuarioRepository.findByCorreo(usuario.getCorreo());
        assertEquals(usuario.getNombres(), savedUsuario.get().getNombres());
    }
}