package com.union.service;

import com.union.model.entity.Coordenador;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;

public interface JwtService {

	String gerarToken(Coordenador coordenador);
	
	Claims obterToken(String token) throws ExpiredJwtException;
	
	boolean isTokenValido(String token);
	
	String obterLoginCoordenador(String token);
}
