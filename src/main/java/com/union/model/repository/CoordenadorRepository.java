package com.union.model.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.union.model.entity.Coordenador;

public interface CoordenadorRepository extends JpaRepository<Coordenador, Integer> {
	
	boolean existsByEmail(String email);

	Optional<Coordenador> findByEmail(String email);
}
