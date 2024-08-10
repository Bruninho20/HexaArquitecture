package br.com.vwco.onedigitalplatform.cliente.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.vwco.onedigitalplatform.cliente.domain.model.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM users_data WHERE LOWER(email) = LOWER(:email)")
	User findUserByEmailIgnoreCase(@Param("email") String email);
	
	List<User> findUserByCpf(String cpf);
	
}