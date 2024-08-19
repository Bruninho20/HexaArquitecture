package br.com.fiap.products.cliente.infrastructure.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fiap.products.cliente.domain.model.User;
import br.com.fiap.products.cliente.infrastructure.repository.UserJpaRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserJpaRepository userJpaRepository;

	public UserDetailsServiceImpl(UserJpaRepository userJpaRepository) {
		this.userJpaRepository = userJpaRepository;
	}

	@Override
	public UserDetailsImpl loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userJpaRepository.findUserByEmailIgnoreCase(email);

		return UserDetailsImpl.build(user);
	}

}
