package com.union.coordenador;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class CoordenadorController {
	
	private final CoordenadorService coordenadorService;

	@Autowired
	public CoordenadorController(CoordenadorService coordenadorService) {
		super();
		this.coordenadorService = coordenadorService;
	}
	
	@GetMapping
	public List<Coordenador> pegarCoordenadores() {
		return coordenadorService.pegarCoordenadores();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void registrarCoordenador(@RequestBody Coordenador coordenador) {
		coordenadorService.adicionarNovoCoordenador(coordenador);
	}
	
}
