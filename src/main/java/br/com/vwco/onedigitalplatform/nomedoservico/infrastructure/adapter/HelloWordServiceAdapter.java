package br.com.vwco.onedigitalplatform.nomedoservico.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vwco.onedigitalplatform.nomedoservico.application.controller.dto.request.HelloWordRequest;
import br.com.vwco.onedigitalplatform.nomedoservico.application.controller.dto.request.HelloWordUpdateRequest;
import br.com.vwco.onedigitalplatform.nomedoservico.application.controller.dto.response.HelloWordResponse;
import br.com.vwco.onedigitalplatform.nomedoservico.domain.model.HelloWord;
import br.com.vwco.onedigitalplatform.nomedoservico.domain.port.outgoing.PersistHelloWordPort;
import br.com.vwco.onedigitalplatform.nomedoservico.domain.port.outgoing.RetrieveHelloWordPort;
import br.com.vwco.onedigitalplatform.nomedoservico.infrastructure.repository.HelloWordRepository;
import br.com.vwco.onedigitalplatform.nomedoservico.mappers.HelloWordMapper;

@Service
public class HelloWordServiceAdapter implements PersistHelloWordPort, RetrieveHelloWordPort {

	@Autowired
	private HelloWordRepository repository;

	@Override
	public HelloWordResponse save(HelloWordRequest request) {
		HelloWord helloword = HelloWordMapper.helloWordRequesttoEntity(request);
		HelloWordResponse response = HelloWordMapper.entityToHelloWordResponse(this.repository.save(helloword));
		return response;
	}

	@Override
	public void deleteById(Integer id) {
		this.repository.deleteById(id);
	}

	@Override
	public List<HelloWordResponse> getAll() {
		List<HelloWord> helloWords = this.repository.findAll();
		return HelloWordMapper.listEntitytoListHelloWordResponse(helloWords);
	}

	@Override
	public HelloWordResponse findById(Integer id) {
		Optional<HelloWord> helloWord = this.repository.findById(id);
		return HelloWordMapper.entityToHelloWordResponse(helloWord.get());
	}

	@Override
	public HelloWordResponse update(HelloWordUpdateRequest request) {
		Optional<HelloWord> helloWord = this.repository.findById(request.getId());
		HelloWord helloword = HelloWordMapper.helloWordUpdateRequesttoEntity(request, helloWord.get());
		return HelloWordMapper.entityToHelloWordResponse(this.repository.save(helloword));
	}

}
