package br.com.fiap.products.cliente.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fiap.products.cliente.domain.model.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM users_data WHERE LOWER(email) = LOWER(:email)")
	User findUserByEmailIgnoreCase(@Param("email") String email);
	
	List<User> findUserByCpf(String cpf);
	
	@Query(value="SELECT * FROM users_data where user_id = :userId", nativeQuery = true)
	User findByUserId(@Param("userId")Long userId);
	
	
}
