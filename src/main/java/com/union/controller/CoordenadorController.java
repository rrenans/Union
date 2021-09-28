package com.union.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.union.coordenador.Coordenador;
import com.union.service.CoordenadorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/")
@Api(value="API Rest Coordenador")
@CrossOrigin(origins="*")
public class CoordenadorController {
	
	private final CoordenadorService coordenadorService;

	@Autowired
	public CoordenadorController(CoordenadorService coordenadorService) {
		super();
		this.coordenadorService = coordenadorService;
	}
	
	@GetMapping
	@ApiOperation(value="Retorna todos os Coordenadores")
	public List<Coordenador> pegarCoordenadores() {
		return coordenadorService.pegarCoordenadores();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Coordenador> pegarCoordenadorPorId(@PathVariable Integer id) {
		return new ResponseEntity<>(coordenadorService.pegarCoordenadorPorId(id), HttpStatus.OK);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Adiciona novo Coordenador")
	public void registrarCoordenador(@RequestBody Coordenador coordenador) {
		coordenadorService.adicionarNovoCoordenador(coordenador);
	}
	
}
