package com.union.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.union.model.entity.Coordenador;

@Repository // responsável por interagir com o db
public interface CoordenadorRepository extends JpaRepository<Coordenador, Integer> {

	// @Query("SELECT s FROM Student s WHERE s.email = ?1") copiei de um antigo
	// código e não entendi
	/*
	 * Optional<Coordenador> findCoordenadorByNome(String nome);
	 * 
	 * Coordenador findCoordenadorById(Integer id);
	 */
	
	boolean existsByEmail(String email);

	Optional<Coordenador> findByEmail(String email);
}
