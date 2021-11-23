package com.union.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.union.model.entity.Funcionario;

public interface FuncionarioService {

	Funcionario salvar(Funcionario funcionario);

	@Transactional
	Funcionario atualizar(Funcionario funcionario);
	
	void deletar(Funcionario funcionario);

	List<Funcionario> buscar(Funcionario funcionarioFiltro);
	
	void validar(Funcionario funcionario);
	
	Optional<Funcionario> obterPorId(Integer id);
}
