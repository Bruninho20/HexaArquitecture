package br.com.vwco.onedigitalplatform.nomedoservico.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vwco.onedigitalplatform.nomedoservico.application.controller.dto.request.HelloWordRequest;
import br.com.vwco.onedigitalplatform.nomedoservico.application.controller.dto.request.HelloWordUpdateRequest;
import br.com.vwco.onedigitalplatform.nomedoservico.application.controller.dto.response.HelloWordResponse;
import br.com.vwco.onedigitalplatform.nomedoservico.domain.port.incoming.HelloWordUseCase;
import br.com.vwco.onedigitalplatform.nomedoservico.domain.port.outgoing.PersistHelloWordPort;
import br.com.vwco.onedigitalplatform.nomedoservico.domain.port.outgoing.RetrieveHelloWordPort;

@Service
public class HelloWordServiceImpl implements HelloWordUseCase {
	
	@Autowired
	private PersistHelloWordPort persistHelloWordPort;
	
	@Autowired
	private RetrieveHelloWordPort retrieveHelloWordPort;
	
	public HelloWordResponse save(HelloWordRequest request) {
		return this.persistHelloWordPort.save(request);
	}
	
	public List<HelloWordResponse> getAll() {
		return this.retrieveHelloWordPort.getAll();
	}
	
	public void deleteById(Integer id) {
		this.persistHelloWordPort.deleteById(id);
	}
	
	public HelloWordResponse update(HelloWordUpdateRequest request) {
		return this.persistHelloWordPort.update(request);
	}

	public HelloWordResponse getById(Integer id) {
		return this.retrieveHelloWordPort.findById(id);
	}
}
