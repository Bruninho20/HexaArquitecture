package br.com.vwco.onedigitalplatform.cliente.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request.HelloWordRequest;
import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request.HelloWordUpdateRequest;
import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.response.HelloWordResponse;
import br.com.vwco.onedigitalplatform.cliente.domain.port.incoming.HelloWordUseCase;
import br.com.vwco.onedigitalplatform.cliente.domain.port.outgoing.ProductPort;
import br.com.vwco.onedigitalplatform.cliente.domain.port.outgoing.RetrieveProductPort;

@Service
public class HelloWordServiceImpl implements HelloWordUseCase {

	@Autowired
	private ProductPort persistHelloWordPort;

	@Autowired
	private RetrieveProductPort retrieveHelloWordPort;

	@Override
	public HelloWordResponse save(HelloWordRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HelloWordResponse> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public HelloWordResponse update(HelloWordUpdateRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HelloWordResponse getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
