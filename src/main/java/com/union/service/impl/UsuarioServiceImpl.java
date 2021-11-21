package com.union.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.union.exceptions.ErroAutenticacao;
import com.union.exceptions.RegraNegocioException;
import com.union.model.entity.Usuario;
import com.union.model.repository.UsuarioRepository;
import com.union.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository usuarioRepository;
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario autenticar(String email, String senha) {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
		
		if(!usuario.isPresent()) {
            throw new ErroAutenticacao("Usuário não encontrado para o email informado.");
        }

        if(!usuario.get().getSenha().equals(senha)) {
            throw new ErroAutenticacao("Senha inválida.");
        }

		
		return usuario.get();
	}

	@Override
	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		validarEmail(usuario.getEmail());
		return usuarioRepository.save(usuario);
	}

	@Override
	public void validarEmail(String email) {
		boolean emailExiste = usuarioRepository.existsByEmail(email);
		if (emailExiste) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com esse e-mail");
		}
	}
}
