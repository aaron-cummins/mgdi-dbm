package cl.cummins.mgdi.unittest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = MgdiApplicationTests.class)
@SpringBootTest()
class MgdiApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("Prueba");
	}



}
