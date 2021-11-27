package com.union.api.controller;

// import org.apache.catalina.webresources.JarWarResourceSet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import com.union.api.dto.CoordenadorDTO;
import com.union.api.dto.TokenDTO;
import com.union.exceptions.ErroAutenticacao;
import com.union.exceptions.RegraNegocioException;
import com.union.model.entity.Coordenador;
import com.union.service.CoordenadorService;
import com.union.service.JwtService;

@RestController
@RequestMapping("/api/coordenador")
@RequiredArgsConstructor
public class CoordenadorController {

	private final CoordenadorService coordenadorService;
	private final JwtService jwtService;

	@PostMapping("/autenticar")
	public ResponseEntity<?> autenticar(@RequestBody CoordenadorDTO dto) {
		try {
			Coordenador coordenadorAutenticado = coordenadorService.autenticar(dto.getEmail(), dto.getSenha());
			
			String token = jwtService.gerarToken(coordenadorAutenticado);			
			TokenDTO tokenDTO = new TokenDTO(coordenadorAutenticado.getNome(), token);
			
			return ResponseEntity.ok(tokenDTO);
		} catch (ErroAutenticacao e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity<Object> salvar(@RequestBody CoordenadorDTO dto) {

		Coordenador coordenador = Coordenador.builder().nome(dto.getNome()).email(dto.getEmail()).senha(dto.getSenha())
				.build();

		try {
			Coordenador coordenadorSalvo = coordenadorService.salvarCoordenador(coordenador);
			return new ResponseEntity<Object>(coordenadorSalvo, HttpStatus.CREATED);
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
