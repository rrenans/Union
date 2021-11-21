package com.union.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.union.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	boolean existsByEmail(String email);

	Optional<Usuario> findByEmail(String email);
}
