package com.union.coordenador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordenadorService {

	@Autowired
	private CoordenadorValidador coordenadorValidador;
	
	private List<Coordenador> coordenador = new ArrayList<>();
	
	private List<Coordenador> mockCoordenador() {
		if (!coordenador.isEmpty()) {
			return coordenador;
		}
		
		coordenador.add(new Coordenador(1, "Renan Silva"));
		
		return coordenador;
	}
	
	// public 
	
}
