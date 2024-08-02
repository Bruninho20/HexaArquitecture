package br.com.vwco.onedigitalplatform.cliente.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vwco.onedigitalplatform.cliente.domain.model.Product;

@Repository
public interface HelloWordRepository extends JpaRepository<Product, Integer> {
	
}
