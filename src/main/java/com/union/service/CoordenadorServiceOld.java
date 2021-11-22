package com.union.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.union.coordenador.CoordenadorOld;
import com.union.model.repository.CoordenadorRepository;

@Service
public class CoordenadorServiceOld {
	
	/*
	 * private final CoordenadorRepository coordenadorRepository; // digamos que o
	 * repository é o db
	 * 
	 * @Autowired public CoordenadorServiceOld(CoordenadorRepository
	 * coordenadorRepository) { super(); this.coordenadorRepository =
	 * coordenadorRepository; }
	 * 
	 * // GET public List<CoordenadorOld> pegarCoordenadores() { return
	 * coordenadorRepository.findAll(); }
	 * 
	 * // GET public CoordenadorOld pegarCoordenadorPorId(Integer id) { return
	 * coordenadorRepository.findCoordenadorById(id); }
	 * 
	 * // POST public void adicionarNovoCoordenador(CoordenadorOld coordenador) {
	 * Optional<CoordenadorOld> coordenadorOptional =
	 * coordenadorRepository.findCoordenadorByNome(coordenador.getNome());
	 * 
	 * if (coordenadorOptional.isPresent()) { throw new
	 * IllegalStateException("nome já cadastrado"); }
	 * 
	 * coordenadorRepository.save(coordenador); }
	 * 
	 * // DELETE public void excluirCoordenador(Integer id) { boolean existente =
	 * coordenadorRepository.existsById(id); if (!existente) { throw new
	 * IllegalStateException("Coordenador com id " + id + " não existe."); }
	 * coordenadorRepository.deleteById(id); }
	 * 
	 * // UPDATE public void editarCoordenador(CoordenadorOld coordenador) {
	 * coordenadorRepository.save(coordenador); }
	 */
}
