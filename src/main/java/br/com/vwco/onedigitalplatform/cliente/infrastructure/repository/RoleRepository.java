package br.com.vwco.onedigitalplatform.cliente.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vwco.onedigitalplatform.cliente.domain.model.UserRole;

public interface RoleRepository extends JpaRepository<UserRole, UUID> {
    UserRole findByRoleName(String roleName);
}
