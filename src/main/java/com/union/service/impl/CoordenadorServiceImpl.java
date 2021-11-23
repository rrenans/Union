package com.union.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.union.exceptions.ErroAutenticacao;
import com.union.exceptions.RegraNegocioException;
import com.union.model.entity.Coordenador;
import com.union.model.repository.CoordenadorRepository;
import com.union.service.CoordenadorService;

@Service
public class CoordenadorServiceImpl implements CoordenadorService {

	private CoordenadorRepository coordenadorRepository;

	public CoordenadorServiceImpl(CoordenadorRepository coordenadorRepository) {
		super();
		this.coordenadorRepository = coordenadorRepository;
	}

	@Override
	public Coordenador autenticar(String email, String senha) {
		Optional<Coordenador> coordenador = coordenadorRepository.findByEmail(email);

		if ((!coordenador.isPresent()) || (!coordenador.get().getSenha().equals(senha))) {
			throw new ErroAutenticacao("Coordenador ou senha inválidos.");
		}

		return coordenador.get();
	}

	@Override
	@Transactional
	public Coordenador salvarCoordenador(Coordenador coordenador) {
		validarEmail(coordenador.getEmail());
		return coordenadorRepository.save(coordenador);
	}

	@Override
	public void validarEmail(String email) {
		boolean emailExiste = coordenadorRepository.existsByEmail(email);
		if (emailExiste) {
			throw new RegraNegocioException("Já existe um Coordenador cadastrado com esse e-mail");
		}
	}	

	@Override
	public Optional<Coordenador> obterPorId(Integer id) {
		return coordenadorRepository.findById(id);
		
	}
}
