package br.com.vwco.onedigitalplatform.cliente.infrastructure.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.response.MessageResponse;
import br.com.vwco.onedigitalplatform.cliente.domain.port.outgoing.ProductPort;
import br.com.vwco.onedigitalplatform.cliente.domain.port.outgoing.RetrieveProductPort;
import br.com.vwco.onedigitalplatform.cliente.infrastructure.repository.UserJpaRepository;

@Service
public class ProductServiceAdapter implements ProductPort, RetrieveProductPort {

	@Autowired
	private UserJpaRepository repository;

	@Override
	public List<MessageResponse> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageResponse findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}




}
