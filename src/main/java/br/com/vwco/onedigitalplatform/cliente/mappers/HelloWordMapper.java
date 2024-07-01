package br.com.vwco.onedigitalplatform.cliente.mappers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request.HelloWordRequest;
import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request.HelloWordUpdateRequest;
import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.response.HelloWordResponse;
import br.com.vwco.onedigitalplatform.cliente.domain.model.HelloWord;

public class HelloWordMapper {
	
	private HelloWordMapper() {
		super();
	}
	
	public static HelloWord helloWordRequesttoEntity(HelloWordRequest request) {
		HelloWord helloWord = new HelloWord();
		helloWord.setDescription(request.getDescription());
		helloWord.setCreatedAt(new Date());
		helloWord.setCreatedBy(request.getCreatedBy());
		helloWord.setUpdatedAt(new Date());
		helloWord.setIsActive(request.getIsActive());
		helloWord.setUpdatedBy(request.getUpdatedBy());
		return helloWord;
	}
	
	public static HelloWord helloWordUpdateRequesttoEntity(HelloWordUpdateRequest request, HelloWord helloWordFound) {
		helloWordFound.setDescription(request.getDescription());
		helloWordFound.setIsActive(request.getIsActive());
		helloWordFound.setCreatedAt(helloWordFound.getCreatedAt());
		helloWordFound.setCreatedBy(helloWordFound.getCreatedBy());
		helloWordFound.setUpdatedAt(new Date());
		helloWordFound.setUpdatedBy(request.getUpdatedBy());
		return helloWordFound;
	}
	
	
	public static HelloWordResponse entityToHelloWordResponse(HelloWord helloWord) {
		HelloWordResponse helloWordResponse = new HelloWordResponse();
		helloWordResponse.setId(helloWord.getId());
		helloWordResponse.setDescription(helloWord.getDescription());
		helloWordResponse.setCreate(helloWord.getCreatedAt());
		helloWordResponse.setCreatedBy(helloWord.getCreatedBy());
		helloWordResponse.setIsActive(helloWord.getIsActive());
		//helloWordResponse.setUpdate(helloWord.getUpdatedAt());
		helloWordResponse.setUpdatedBy(helloWord.getUpdatedBy());
		return helloWordResponse;
	}
	
	
	public static List<HelloWordResponse> listEntitytoListHelloWordResponse( List<HelloWord> helloWords) {
		
		return helloWords.stream()
		        .map(helloWord -> new HelloWordResponse(helloWord.getId(), 
		        										 helloWord.getDescription(),
		        										 helloWord.getCreatedAt(),
		        										 helloWord.getCreatedBy(),
		        										 helloWord.getIsActive(),
		        										 helloWord.getUpdatedAt(),
		        										 helloWord.getUpdatedBy()
		        		))
		        .collect(Collectors.toList());
	}

}
