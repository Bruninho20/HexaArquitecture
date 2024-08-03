package br.com.vwco.onedigitalplatform.cliente.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vwco.onedigitalplatform.cliente.domain.model.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {

	User findUserByEmailIgnoreCase(String email);
	
	List<User> findUserByCpf(String cpf);
	
}
