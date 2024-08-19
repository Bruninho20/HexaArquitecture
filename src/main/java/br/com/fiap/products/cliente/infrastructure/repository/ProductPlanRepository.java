package br.com.fiap.products.cliente.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.products.cliente.domain.model.Product;

public interface ProductPlanRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT p.*, up.user_id AS userId "
	        + "FROM product p "
	        + "JOIN user_product up ON p.product_id = up.product_id "
	        + "WHERE up.user_id = :userId "
	        + "AND p.subscription_type_id = :subTypeId", nativeQuery = true)
	List<Object[]> findByValueUser(@Param("userId") Long userId, @Param("subTypeId") Long subTypeId);



}
