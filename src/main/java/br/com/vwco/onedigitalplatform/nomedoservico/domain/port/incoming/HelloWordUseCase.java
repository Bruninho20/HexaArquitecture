package br.com.vwco.onedigitalplatform.nomedoservico.domain.port.incoming;

import java.util.List;

import br.com.vwco.onedigitalplatform.nomedoservico.application.controller.dto.request.HelloWordRequest;
import br.com.vwco.onedigitalplatform.nomedoservico.application.controller.dto.request.HelloWordUpdateRequest;
import br.com.vwco.onedigitalplatform.nomedoservico.application.controller.dto.response.HelloWordResponse;

public interface HelloWordUseCase {

	public HelloWordResponse save(HelloWordRequest request);
	
	public List<HelloWordResponse> getAll();
	
	public void deleteById(Integer id);
	
	public HelloWordResponse update(HelloWordUpdateRequest request);
	
	public HelloWordResponse getById(Integer id);
}
