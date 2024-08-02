package br.com.vwco.onedigitalplatform.cliente.domain.port.outgoing;

import java.util.List;
import java.util.Optional;

import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.response.HelloWordResponse;

public interface RetrieveProductPort {
	
	List<HelloWordResponse> getAll();
	
	HelloWordResponse findById(Integer id);

}
