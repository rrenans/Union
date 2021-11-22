package com.union.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import com.union.api.dto.CoordenadorDTO;
import com.union.coordenador.CoordenadorOld;
import com.union.exceptions.ErroAutenticacao;
import com.union.exceptions.RegraNegocioException;
import com.union.model.entity.Usuario;
import com.union.service.CoordenadorServiceOld;
import com.union.service.UsuarioService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioService service;	
	
	/*
	 * @Autowired public UsuarioController(UsuarioService service) { super();
	 * this.service = service; }
	 */

	@PostMapping("/autenticar")
	public ResponseEntity<Object> autenticar(@RequestBody CoordenadorDTO dto) {
		try {
			Usuario usuarioAutenticado = service.autenticar(dto.getEmail(), dto.getSenha());
			return ResponseEntity.ok(usuarioAutenticado);
		} catch (ErroAutenticacao e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
    public ResponseEntity<Object> salvar(@RequestBody CoordenadorDTO dto) {

        Usuario usuario = Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha()).build();

        try {
            Usuario usuarioSalvo = service.salvarUsuario(usuario);
            return new ResponseEntity<Object>(usuarioSalvo, HttpStatus.CREATED);
        }catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

	// @GetMapping("{id}/saldo")
	// public ResponseEntity obterSaldo( @PathVariable("id") Long id ) {
	// Optional<Usuario> usuario = service.obterPorId(id);

	// if(!usuario.isPresent()) {
	// return new ResponseEntity( HttpStatus.NOT_FOUND );
	// }
//
	// BigDecimal saldo = lancamentoService.obterSaldoPorUsuario(id);
	// return ResponseEntity.ok(saldo);
	// }
}
