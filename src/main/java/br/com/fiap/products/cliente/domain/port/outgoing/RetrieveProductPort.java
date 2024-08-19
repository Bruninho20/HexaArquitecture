package br.com.fiap.products.cliente.domain.port.outgoing;

import java.util.List;
import java.util.Optional;

import br.com.fiap.products.cliente.application.controller.dto.response.MessageResponse;

public interface RetrieveProductPort {
	
	List<MessageResponse> getAll();
	
	MessageResponse findById(Integer id);

}
