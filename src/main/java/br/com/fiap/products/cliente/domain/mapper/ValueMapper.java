package br.com.fiap.products.cliente.domain.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.fiap.products.cliente.application.controller.dto.response.ClientResponse;
import br.com.fiap.products.cliente.application.controller.dto.response.InternetResponse;

@Component
public class ValueMapper {

	public List<ClientResponse> toDtoList(List<Object[]> products) {
		return products.stream().map(this::toDto).collect(Collectors.toList());
	}

	public ClientResponse toDto(Object[] productData) {
	    ClientResponse productResponse = new ClientResponse();
	    productResponse.setId(productData[0].toString());
	    productResponse.setStatus("active");
	    productResponse.setProductName(productData[1].toString());
	    productResponse.setIdentifiers(List.of(productData[2].toString()));
	    productResponse.setProductType(productData[3].toString());
	    productResponse.setStartDate("2022-03-14T23:00:00+01:00");
	    productResponse.setSubscriptionType("prepaid");

	    ClientResponse.Description description = new ClientResponse.Description();
	    description.setText(productData[4].toString());
	    productResponse.setDescriptions(List.of(description));

	    List<ClientResponse> subProducts = new ArrayList<>();
	    
	    ClientResponse subProduct1 = new ClientResponse();
	    subProduct1.setId("24523asfgaswtrwetr");
	    subProduct1.setStatus("active");
	    subProduct1.setProductName("Vivo pós 20GB");
	    subProduct1.setIdentifiers(List.of("+51999901001"));
	    subProduct1.setProductType("mobile");
	    subProduct1.setStartDate("2023-01-01T18:30:00+01:00");

	    ClientResponse.Description subProductDescription1 = new ClientResponse.Description();
	    subProductDescription1.setText("Descrição do subproduto 1");
	    subProduct1.setDescriptions(List.of(subProductDescription1));
	    
	    subProducts.add(subProduct1);


	    productResponse.setSubProducts(subProducts);

	    return productResponse;
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
			response.setDescriptions(Collections.singletonList(new InternetResponse.Description((String) objArray[3])));

			responseList.add(response);
		}

		return responseList;
	}
}
