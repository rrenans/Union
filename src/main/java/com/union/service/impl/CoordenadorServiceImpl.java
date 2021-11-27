package com.union.service.impl;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
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
	private PasswordEncoder encoder;

	public CoordenadorServiceImpl(CoordenadorRepository coordenadorRepository, PasswordEncoder encoder) {
		super();
		this.coordenadorRepository = coordenadorRepository;
		this.encoder = encoder;
	}

	@Override
	public Coordenador autenticar(String email, String senha) {
		Optional<Coordenador> coordenador = coordenadorRepository.findByEmail(email);		

		if (!coordenador.isPresent()) {
			throw new ErroAutenticacao("Coordenador ou senha inválidos.");
		}
		
		boolean senhasIguais = encoder.matches(senha, coordenador.get().getSenha());
		
		if (!senhasIguais) {
			throw new ErroAutenticacao("Coordenador ou senha inválidos.");
		}

		return coordenador.get();
	}

	@Override
	@Transactional
	public Coordenador salvarCoordenador(Coordenador coordenador) {
		validarEmail(coordenador.getEmail());
		criptografarSenha(coordenador);
		return coordenadorRepository.save(coordenador);
	}

	private void criptografarSenha(Coordenador coordenador) {
		String senha = coordenador.getSenha();
		String senhaCripto = encoder.encode(senha);
		coordenador.setSenha(senhaCripto);
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
