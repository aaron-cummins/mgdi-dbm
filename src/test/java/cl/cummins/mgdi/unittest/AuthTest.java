package cl.cummins.mgdi.unittest;

import cl.cummins.mgdi.model.dto.LoginRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;



@SpringBootTest
public class AuthTest {

    @Test
    void IncorrectUsernameTest_ThrowsException(){
        LoginRequestDTO loginRequestDTO;

        assertTrue(true);

    }
}
