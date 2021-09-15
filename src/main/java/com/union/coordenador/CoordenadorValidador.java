package com.union.coordenador;

import org.springframework.stereotype.Component;

@Component
public class CoordenadorValidador {

	public String validarCoordenador(Coordenador coordenador) {
		if (coordenador == null) {
			return "Coordenador não existe";
		}
		
		return "";
	}
	
}
