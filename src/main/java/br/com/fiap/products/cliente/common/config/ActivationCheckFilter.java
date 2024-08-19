package br.com.fiap.products.cliente.common.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.fiap.products.cliente.infrastructure.repository.UserJpaRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ActivationCheckFilter extends OncePerRequestFilter {

	@Autowired
	private UserJpaRepository userJpaRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String username = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}

		if (username != null) {
			var user = userJpaRepository.findUserByEmailIgnoreCase(username);
			if (user != null && !user.getIsActivated()) {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				response.getWriter().write("Conta não ativada.");
				return;
			}
		}

		filterChain.doFilter(request, response);
	}

}
