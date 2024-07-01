package br.com.vwco.onedigitalplatform.nomedoservico.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vwco.onedigitalplatform.nomedoservico.domain.model.HelloWord;

@Repository
public interface HelloWordRepository extends JpaRepository<HelloWord, Integer> {
	
}
