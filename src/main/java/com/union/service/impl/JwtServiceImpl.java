package com.union.service.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.union.model.entity.Coordenador;
import com.union.service.JwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
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
				.claim("userid", coordenador.getId())
				.claim("nome", coordenador.getNome())
				.claim("horaExpiracao", horaExpiracaoToken)
				.signWith(SignatureAlgorithm.HS512, chaveAssinatura)
				.compact();

		return token;
	}

	@Override
	public Claims obterClaims(String token) throws ExpiredJwtException {
		
		return Jwts.parser()
				.setSigningKey(chaveAssinatura)
				.parseClaimsJws(token)
				.getBody();
	}

	@Override
	public boolean isTokenValido(String token) {
		try {
			Claims claims = obterClaims(token);
			Date dataEx = claims.getExpiration();
			LocalDateTime dataExpiracao = dataEx.toInstant()
					.atZone(ZoneId.systemDefault()).toLocalDateTime();
			
			boolean dataHoraAtualIsAfterDataExpiracao = LocalDateTime.now().isAfter(dataExpiracao);
			return !dataHoraAtualIsAfterDataExpiracao;
		}catch(ExpiredJwtException e) {
			
			return false;
		}
	}

	@Override
	public String obterLoginCoordenador(String token) {
		Claims claims = obterClaims(token);
		
		return claims.getSubject();
	}
}
