package com.union.service;

import java.util.Optional;

import com.union.model.entity.Coordenador;

public interface CoordenadorService {

	Coordenador autenticar(String email, String senha);

	Coordenador salvarCoordenador(Coordenador coordenador);

	void validarEmail(String email);

	Optional<Coordenador> obterPorId(Integer id);

}
