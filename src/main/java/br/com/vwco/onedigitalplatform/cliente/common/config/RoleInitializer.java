package br.com.vwco.onedigitalplatform.cliente.common.config;

import java.util.HashSet;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.vwco.onedigitalplatform.cliente.domain.model.UserRole;
import br.com.vwco.onedigitalplatform.cliente.infrastructure.repository.RoleRepository;

@Component
public class RoleInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.findByRoleName("ADMIN") == null) {
            roleRepository.save(new UserRole(UUID.randomUUID(), "ADMIN", new HashSet<>()));
        }

        if (roleRepository.findByRoleName("USER") == null) {
            roleRepository.save(new UserRole(UUID.randomUUID(), "USER", new HashSet<>()));
        }
    }
}