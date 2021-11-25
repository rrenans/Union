package com.union.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.union.model.entity.Coordenador;
import com.union.model.repository.CoordenadorRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	private CoordenadorRepository coordenadorRepository;

	public SecurityUserDetailsService(CoordenadorRepository coordenadorRepository) {
		this.coordenadorRepository = coordenadorRepository;

	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Coordenador coordenadorEncontrado = coordenadorRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Email não cadastrado."));

		return User.builder()
				.username(coordenadorEncontrado.getEmail())
				.password(coordenadorEncontrado.getSenha())
				.roles("USER")
				.build();
	}
}
