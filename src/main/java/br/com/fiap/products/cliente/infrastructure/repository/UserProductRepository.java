package br.com.fiap.products.cliente.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.products.cliente.domain.model.User;
import br.com.fiap.products.cliente.domain.model.UserProduct;

public interface UserProductRepository extends JpaRepository<UserProduct, Long> {
	
	
	List<UserProduct> findByUser(User user);
	
	
	@Query(value = "SELECT * FROM user_product WHERE product_id = :productId AND user_id = :userId", nativeQuery = true)
	List<UserProduct> findByStatus(@Param("productId") Long productId, @Param("userId") Long userId);
	
	



}
