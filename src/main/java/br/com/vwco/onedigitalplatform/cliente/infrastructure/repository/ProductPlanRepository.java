package br.com.vwco.onedigitalplatform.cliente.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vwco.onedigitalplatform.cliente.domain.model.Product;

public interface ProductPlanRepository extends JpaRepository<Product, Long> {

}
