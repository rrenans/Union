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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.union.coordenador.CoordenadorOld;
import com.union.service.CoordenadorServiceOld;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/coordenador")
@Api(value="API Rest Coordenador")
@CrossOrigin(origins="*")
public class CoordenadorController {

	/*private final CoordenadorServiceOld coordenadorService;
	
	@Autowired
	public CoordenadorController(CoordenadorServiceOld coordenadorService) {
		super();
		this.coordenadorService = coordenadorService;
	}
	
	@GetMapping
	@ApiOperation(value="Retorna todos os Coordenadores")
	public List<CoordenadorOld> pegarCoordenadores() {
		return coordenadorService.pegarCoordenadores();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Retorna apenas um Coordenador de acordo com o seu Id")
	public ResponseEntity<CoordenadorOld> pegarCoordenadorPorId(@PathVariable Integer id) {
		return new ResponseEntity<>(coordenadorService.pegarCoordenadorPorId(id), HttpStatus.OK);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Adiciona novo Coordenador")
	public void registrarCoordenador(@RequestBody CoordenadorOld coordenador) {
		coordenadorService.adicionarNovoCoordenador(coordenador);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="Apaga apenas um Coordenador de acordo com o seu Id")
	public void excluirCoordenador(@PathVariable("id") Integer id) {
		coordenadorService.excluirCoordenador(id);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value="Edita apenas um Coordenador de acordo com o seu Id")
	public void editarCoordenador(@RequestBody CoordenadorOld coordenador) {
		coordenadorService.editarCoordenador(coordenador);*/
	//}
}
