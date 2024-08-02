package br.com.vwco.onedigitalplatform.cliente.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request.HelloWordRequest;
import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request.HelloWordUpdateRequest;
import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.response.HelloWordResponse;
import br.com.vwco.onedigitalplatform.cliente.domain.model.Product;
import br.com.vwco.onedigitalplatform.cliente.domain.port.outgoing.ProductPort;
import br.com.vwco.onedigitalplatform.cliente.domain.port.outgoing.RetrieveProductPort;
import br.com.vwco.onedigitalplatform.cliente.infrastructure.repository.HelloWordRepository;
import br.com.vwco.onedigitalplatform.cliente.mappers.ProductMapper;

@Service
public class ProductServiceAdapter implements ProductPort, RetrieveProductPort {

	@Autowired
	private HelloWordRepository repository;

	@Override
	public List<HelloWordResponse> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HelloWordResponse findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}




}
