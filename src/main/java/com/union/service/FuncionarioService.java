
package com.union.service;

import java.util.List;

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
	
	// GET
	public Funcionario pegarFuncionarioPorId(Integer id) {
		return funcionarioRepository.findFuncionarioById(id);
	}
	
	// POST
	public void adicionarFuncionario(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}
	
	// DELETE
	public void excluirFuncionario(Integer id) {
		boolean existente = funcionarioRepository.existsById(id);
		
		if (!existente) {
			throw new IllegalStateException("Funcionario com id " + id + " não existe.");
		}
		funcionarioRepository.deleteById(id);
	}
	
	// UPDATE
	public void editarFuncionario(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}
}
