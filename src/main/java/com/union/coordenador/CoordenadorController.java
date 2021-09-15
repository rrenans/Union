package com.union.coordenador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class CoordenadorController {
	
	private List<Coordenador> coordenadores = new ArrayList<>();
	
	@GetMapping
	public List<Coordenador> getCoordenador() {
		return coordenadores;
	}
	
	@PostMapping
	public Coordenador coordenador(@RequestBody Coordenador coordenador) {
		coordenadores.add(coordenador);
		return coordenador;
	} 
	
}
