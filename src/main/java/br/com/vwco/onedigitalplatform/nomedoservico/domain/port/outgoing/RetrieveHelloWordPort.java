package br.com.vwco.onedigitalplatform.nomedoservico.domain.port.outgoing;

import java.util.List;
import java.util.Optional;

import br.com.vwco.onedigitalplatform.nomedoservico.application.controller.dto.response.HelloWordResponse;

public interface RetrieveHelloWordPort {
	
	List<HelloWordResponse> getAll();
	
	HelloWordResponse findById(Integer id);

}
