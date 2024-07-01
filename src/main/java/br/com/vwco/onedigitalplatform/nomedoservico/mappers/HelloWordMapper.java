package br.com.vwco.onedigitalplatform.nomedoservico.mappers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.vwco.onedigitalplatform.nomedoservico.application.controller.dto.request.HelloWordRequest;
import br.com.vwco.onedigitalplatform.nomedoservico.application.controller.dto.request.HelloWordUpdateRequest;
import br.com.vwco.onedigitalplatform.nomedoservico.application.controller.dto.response.HelloWordResponse;
import br.com.vwco.onedigitalplatform.nomedoservico.domain.model.HelloWord;

public class HelloWordMapper {
	
	private HelloWordMapper() {
		super();
	}
	
	public static HelloWord helloWordRequesttoEntity(HelloWordRequest request) {
		HelloWord helloWord = new HelloWord();
		helloWord.setDescription(request.getDescription());
		helloWord.setCreate(new Date());
		helloWord.setCreatedBy(request.getCreatedBy());
		helloWord.setUpdate(new Date());
		helloWord.setIsActive(request.getIsActive());
		helloWord.setUpdatedBy(request.getUpdatedBy());
		return helloWord;
	}
	
	public static HelloWord helloWordUpdateRequesttoEntity(HelloWordUpdateRequest request, HelloWord helloWordFound) {
		helloWordFound.setDescription(request.getDescription());
		helloWordFound.setIsActive(request.getIsActive());
		helloWordFound.setCreate(helloWordFound.getCreate());
		helloWordFound.setCreatedBy(helloWordFound.getCreatedBy());
		helloWordFound.setUpdate(new Date());
		helloWordFound.setUpdatedBy(request.getUpdatedBy());
		return helloWordFound;
	}
	
	
	public static HelloWordResponse entityToHelloWordResponse(HelloWord helloWord) {
		HelloWordResponse helloWordResponse = new HelloWordResponse();
		helloWordResponse.setId(helloWord.getId());
		helloWordResponse.setDescription(helloWord.getDescription());
		helloWordResponse.setCreate(helloWord.getCreate());
		helloWordResponse.setCreatedBy(helloWord.getCreatedBy());
		helloWordResponse.setIsActive(helloWord.getIsActive());
		helloWordResponse.setUpdate(helloWord.getUpdate());
		helloWordResponse.setUpdatedBy(helloWord.getUpdatedBy());
		return helloWordResponse;
	}
	
	
	public static List<HelloWordResponse> listEntitytoListHelloWordResponse( List<HelloWord> helloWords) {
		
		return helloWords.stream()
		        .map(helloWord -> new HelloWordResponse(helloWord.getId(), 
		        										 helloWord.getDescription(),
		        										 helloWord.getCreate(),
		        										 helloWord.getCreatedBy(),
		        										 helloWord.getIsActive(),
		        										 helloWord.getUpdate(),
		        										 helloWord.getUpdatedBy()
		        		))
		        .collect(Collectors.toList());
	}

}
