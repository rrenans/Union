
package com.union.service;

import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.union.funcionario.Funcionario;
import com.union.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	private final FuncionarioRepository funcionarioRepository;
	
	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		super();
		this.funcionarioRepository = funcionarioRepository;
	}
	
	// GET
	public List<Funcionario> pegarFuncionarios() {
		return funcionarioRepository.findAll();
	}
	
	// POST
	public void adicionarFuncionario(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
		
	}
}
