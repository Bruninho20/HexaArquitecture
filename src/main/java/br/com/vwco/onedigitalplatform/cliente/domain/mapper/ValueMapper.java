package br.com.vwco.onedigitalplatform.cliente.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.response.ClientResponse;

@Component
public class ValueMapper {

	public List<ClientResponse> mapToProductDTOList(List<Object[]> objList) {
		List<ClientResponse> responseList = new ArrayList<>();

		for (Object[] objArray : objList) {
			ClientResponse response = new ClientResponse(
					(Long) objArray[0], 
					(String) objArray[1], 
					(String) objArray[2], 
					(String) objArray[3],
					(String) objArray[4], 
					(Integer) objArray[5], 
					(Long) objArray[6] 
			);

			responseList.add(response);
		}

		return responseList;
	}
}
