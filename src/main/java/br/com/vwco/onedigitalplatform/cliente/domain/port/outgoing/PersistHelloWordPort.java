package br.com.vwco.onedigitalplatform.cliente.domain.port.outgoing;

import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request.HelloWordRequest;
import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request.HelloWordUpdateRequest;
import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.response.HelloWordResponse;

public interface PersistHelloWordPort {
	  
	HelloWordResponse save(HelloWordRequest request);
	
	void deleteById(Integer id);
	
	HelloWordResponse update(HelloWordUpdateRequest request);

}
