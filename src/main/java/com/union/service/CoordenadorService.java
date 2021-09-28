package com.union.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.union.coordenador.Coordenador;
import com.union.repository.CoordenadorRepository;

@Service
public class CoordenadorService {
	
	private final CoordenadorRepository coordenadorRepository; // digamos que o repository é o db
	
	@Autowired // injetando uma instância do repositorio aqui ( injeção direta ? )
	public CoordenadorService(CoordenadorRepository coordenadorRepository) {
		super();
		this.coordenadorRepository = coordenadorRepository;
	}
	
	// GET
	public List<Coordenador> pegarCoordenadores() {
		return coordenadorRepository.findAll();
	}
	
	// GET
	public Coordenador pegarCoordenadorPorId(Integer id) {
		return coordenadorRepository.findCoordenadorById(id);
	}
	
	// POST
	public void adicionarNovoCoordenador(Coordenador coordenador) {
		Optional<Coordenador> coordenadorOptional = coordenadorRepository.findCoordenadorByNome(coordenador.getNome());
		
		if (coordenadorOptional.isPresent()) {
			throw new IllegalStateException("nome já cadastrado");
		}
		
		coordenadorRepository.save(coordenador);
	}
	
}
