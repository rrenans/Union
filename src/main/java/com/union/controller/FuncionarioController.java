package com.union.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.union.funcionario.Funcionario;
import com.union.service.FuncionarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/f")
@Api(value="API Rest Funcionario")
@CrossOrigin(origins="*")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	/*
	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		super();
		this.funcionarioService = funcionarioService;
	}*/
	
	@GetMapping("/funcionario")
	@ApiOperation(value="Retorna todos os Funcionarios")
	public List<Funcionario> pegarFuncionarios() {
		return funcionarioService.pegarFuncionarios();
	}
	
	@PostMapping("/funcionario")
	public void registrarFuncionario(@RequestBody Funcionario funcionario) {
		funcionarioService.adicionarFuncionario(funcionario);
	}
	
	
}
