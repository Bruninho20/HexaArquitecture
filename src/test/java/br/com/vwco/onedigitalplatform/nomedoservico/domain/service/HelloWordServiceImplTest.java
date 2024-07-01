package br.com.vwco.onedigitalplatform.nomedoservico.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
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

import br.com.vwco.onedigitalplatform.nomedoservico.application.controller.dto.response.HelloWordResponse;
import br.com.vwco.onedigitalplatform.nomedoservico.domain.model.HelloWord;
import br.com.vwco.onedigitalplatform.nomedoservico.domain.port.outgoing.PersistHelloWordPort;
import br.com.vwco.onedigitalplatform.nomedoservico.domain.port.outgoing.RetrieveHelloWordPort;
import br.com.vwco.onedigitalplatform.nomedoservico.infrastructure.repository.HelloWordRepository;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase
@TestPropertySource(locations = "classpath:application-test.yml")
@ExtendWith(MockitoExtension.class)
public class HelloWordServiceImplTest {
	
	@InjectMocks
	//@Autowired
	private HelloWordServiceImpl service;
	
	@Mock
	private PersistHelloWordPort persistHelloWordPort;
	
	@Mock
	private RetrieveHelloWordPort retrieveHelloWordPort;
	
	private HelloWordResponse response;
	
	@Autowired
	private HelloWordRepository repository;
	
	private HelloWord entity;
	
	@BeforeEach
	public void setup() {
		response = new HelloWordResponse(1, "Teste Unitario" , new Date(), "user-test",  "S", new Date(), "user-test");
		entity = new HelloWord(1, "Teste Unitario" , new Date(), new Date(), "user-test", "user-test", "S");
	}
	
	@Test
	@DisplayName("Test get all Hello Words Entits with Sucess")
	void test_getAll_Sucess() {
		
		when(this.retrieveHelloWordPort.getAll()).thenReturn(Collections.singletonList(response));
		
		List<HelloWordResponse> responseReturned = service.getAll();
		
		assertEquals(responseReturned, Collections.singletonList(response));
		verify(retrieveHelloWordPort, atLeastOnce()).getAll();
		verifyNoMoreInteractions(retrieveHelloWordPort);
	}
	
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
