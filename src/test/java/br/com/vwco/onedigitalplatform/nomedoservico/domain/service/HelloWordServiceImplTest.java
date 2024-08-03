package br.com.vwco.onedigitalplatform.nomedoservico.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.response.MessageResponse;
import br.com.vwco.onedigitalplatform.cliente.domain.model.Product;
import br.com.vwco.onedigitalplatform.cliente.domain.port.outgoing.ProductPort;
import br.com.vwco.onedigitalplatform.cliente.domain.port.outgoing.RetrieveProductPort;
import br.com.vwco.onedigitalplatform.cliente.domain.service.ClientService;
import br.com.vwco.onedigitalplatform.cliente.infrastructure.repository.UserJpaRepository;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase
@TestPropertySource(locations = "classpath:application-test.yml")
@ExtendWith(MockitoExtension.class)
public class HelloWordServiceImplTest {
	
	@InjectMocks
	//@Autowired
	private ClientService service;
	
	@Mock
	private ProductPort persistHelloWordPort;
	
	@Mock
	private RetrieveProductPort retrieveHelloWordPort;
	
	private MessageResponse response;
	
	@Autowired
	private UserJpaRepository repository;
	
	private Product entity;
	

//	
//	@Test
//	@DisplayName("Test get all Hello Words Entits with Sucess")
//	void test_getAll_Sucess() {
//		
//		when(this.retrieveHelloWordPort.getAll()).thenReturn(Collections.singletonList(response));
//		
//		List<HelloWordResponse> responseReturned = service.crateUser(null);
//		
//		assertEquals(responseReturned, Collections.singletonList(response));
//		verify(retrieveHelloWordPort, atLeastOnce()).getAll();
//		verifyNoMoreInteractions(retrieveHelloWordPort);
//	}
//	
//	@Test
//	@DisplayName("Test get all Hello Words Entits with Sucess")
//	void test_getAll_Sucess_IT() {
//		
//		repository.save(entity);
//		
//		List<HelloWordResponse> responseReturned = service.getAll();
//		
//		assertEquals(responseReturned.get(0).getId(), response.getId());
//		assertEquals(responseReturned.get(0).getDescription(), response.getDescription());
//		assertEquals(responseReturned.get(0).getCreatedBy(), response.getCreatedBy());
//	}
	

}
