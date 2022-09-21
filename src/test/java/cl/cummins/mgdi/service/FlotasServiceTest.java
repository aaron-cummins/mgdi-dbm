package cl.cummins.mgdi.service;

import cl.cummins.mgdi.exeption.service.FlotasService;
import cl.cummins.mgdi.model.Flotas;
import cl.cummins.mgdi.repository.IFlotasRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class FlotasServiceTest {

	@Mock
	private IFlotasRepository flotasRepository;

	@InjectMocks
	private FlotasService flotasService;

	private Flotas flota = new Flotas(
			1L,
			"930 E",
			true,
			null,
			null);

	@Test
	void smoke_Test(){
		assertNotNull(flotasService);
	}

	@Test
	void findAll(){
		flotasService.findAll();
		verify(flotasRepository).findAll();
	}



}
