package com.union.service;

import java.util.List;
import java.util.Optional;

import com.union.model.entity.Funcionario;

public interface FuncionarioService {

	Funcionario salvar(Funcionario funcionario);

	Funcionario atualizar(Funcionario funcionario);

	void deletar(Funcionario funcionario);

	List<Funcionario> buscar(Funcionario funcionarioFiltro);
	
	void validar(Funcionario funcionario);
	
	Optional<Funcionario> obterPorId(Integer id);
}
