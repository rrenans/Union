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
	
	@Autowired
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
		// podemos comentar toda a regra aqui
		Optional<Coordenador> coordenadorOptional = coordenadorRepository.findCoordenadorByNome(coordenador.getNome());
		
		if (coordenadorOptional.isPresent()) {
			throw new IllegalStateException("nome já cadastrado");
		}
		
		coordenadorRepository.save(coordenador);
	}
	
	// DELETE
	public void excluirCoordenador(Integer id) {
		boolean existente = coordenadorRepository.existsById(id);
		if (!existente) {
			throw new IllegalStateException("Coordenador com id " + id + " não existe.");
		}
		coordenadorRepository.deleteById(id);
	}
	
	// UPDATE
	public void editarCoordenador(Coordenador coordenador) {
		coordenadorRepository.save(coordenador);
	}
}
