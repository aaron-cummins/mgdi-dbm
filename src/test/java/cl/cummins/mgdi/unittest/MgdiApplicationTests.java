package cl.cummins.mgdi.unittest;

import cl.cummins.mgdi.MgdiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = MgdiApplication.class)
@SpringBootTest
class MgdiApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("Prueba");
	}

}
