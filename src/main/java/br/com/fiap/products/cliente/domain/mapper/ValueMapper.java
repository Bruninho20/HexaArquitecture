package br.com.fiap.products.cliente.domain.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.fiap.products.cliente.application.controller.dto.response.ClientResponse;
import br.com.fiap.products.cliente.application.controller.dto.response.InternetResponse;

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
	
	
	 public List<InternetResponse> mapToInternetDTOList(List<Object[]> objList) {
	        List<InternetResponse> responseList = new ArrayList<>();

	        for (Object[] objArray : objList) {
	            InternetResponse response = new InternetResponse();
	            response.setId((String) objArray[0].toString());  
	            response.setStatus("active");
	            response.setProductName((String) objArray[1]);
	            response.setIdentifiers(Collections.singletonList("+51939791073"));
	            response.setProductType("internet");
	            response.setStartDate("2024-03-14T23:00:00+01:00");
	            response.setDescriptions(Collections.singletonList(
	                new InternetResponse.Description((String) objArray[3])
	            ));

	            responseList.add(response);
	        }

	        return responseList;
	    }
}
