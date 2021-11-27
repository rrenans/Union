package com.union.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.ExampleMatcher;

import com.union.exceptions.RegraNegocioException;
import com.union.model.entity.Funcionario;
import com.union.model.repository.FuncionarioRepository;
import com.union.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	@Override
	@Transactional
	public Funcionario salvar(Funcionario funcionario) {
		validar(funcionario);
		return funcionarioRepository.save(funcionario);
	}

	@Override
	@Transactional
	public Funcionario atualizar(Funcionario funcionario) {
		Objects.requireNonNull(funcionario.getId());
		validar(funcionario);
		return funcionarioRepository.save(funcionario);
	}

	@Override
	@Transactional
	public void deletar(Funcionario funcionario) {
		Objects.requireNonNull(funcionario.getId());
		
		funcionarioRepository.delete(funcionario);
	}

	@Override
	public List<Funcionario> buscar(Funcionario funcionarioFiltro) {
		Example example = Example.of(funcionarioFiltro,
				ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));

		return funcionarioRepository.findAll(example);
	}

	@Override
	public void validar(Funcionario funcionario) {

		if (funcionario.getNome() == null || funcionario.getNome().trim().equals("")) {
			throw new RegraNegocioException("Informe um Nome válido.");
		}

		if (funcionario.getCpf() == null || funcionario.getCpf().length() != 11) {
			throw new RegraNegocioException("CPF inválido.");
		}		
	}

	@Override
	public Optional<Funcionario> obterPorId(Integer id) {		
		return funcionarioRepository.findById(id);
	}
}
