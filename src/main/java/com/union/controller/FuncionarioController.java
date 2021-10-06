package com.union.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.union.funcionario.Funcionario;
import com.union.service.FuncionarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/funcionario")
@Api(value="API Rest Funcionario")
@CrossOrigin(origins="*")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping
	@ApiOperation(value="Retorna todos os Funcionarios")
	public List<Funcionario> pegarFuncionarios() {
		return funcionarioService.pegarFuncionarios();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Retorna apenas um Funcionario de acordo com Id")
	public ResponseEntity<Funcionario> pegarFuncionarioPorId(@PathVariable Integer id) {
		return new ResponseEntity<>(funcionarioService.pegarFuncionarioPorId(id), HttpStatus.OK);
	}
	
	@PostMapping
	@ApiOperation(value="Adiciona novo Funcionario")
	public void registrarFuncionario(@RequestBody Funcionario funcionario) {
		funcionarioService.adicionarFuncionario(funcionario);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="Apaga um Funcionario de acordo com seu Id")
	public void excluirFuncionario(@PathVariable("id") Integer id) {
		funcionarioService.excluirFuncionario(id);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value="Edita um Funcionario de acordo com seu Id")
	public void editarFuncionario(@RequestBody Funcionario funcionario) {
		funcionarioService.editarFuncionario(funcionario);
	}
	
}
