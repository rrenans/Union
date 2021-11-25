package com.union.service.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import com.union.model.entity.Coordenador;
import com.union.service.JwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtServiceImpl implements JwtService {

	@Value("${jwt.expiracao}")
	private String expiracao;

	@Value("{jwt.chave-assinatura}")
	private String chaveAssinatura;

	@Override
	public String gerarToken(Coordenador coordenador) {
		long exp = Long.valueOf(expiracao);
		LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(exp);
		Instant instante = dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant();
		Date data = Date.from(instante);
		
		String horaExpiracaoToken = dataHoraExpiracao.toLocalTime()
				.format(DateTimeFormatter.ofPattern("HH:mm"));
								
		String token = Jwts.builder()
				.setExpiration(data)
				.setSubject(coordenador.getEmail())
				.claim("nome", coordenador.getNome())
				.claim("horaExpiracao", horaExpiracaoToken)
				.signWith(SignatureAlgorithm.HS512, chaveAssinatura)
				.compact();

		return token;
	}

	@Override
	public Claims obterToken(String token) throws ExpiredJwtException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTokenValido(String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String obterLoginCoordenador(String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
