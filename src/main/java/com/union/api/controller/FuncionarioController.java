package com.union.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.union.api.dto.FuncionarioDTO;
import com.union.exceptions.RegraNegocioException;
import com.union.model.entity.Coordenador;
import com.union.model.entity.Funcionario;
import com.union.service.CoordenadorService;
import com.union.service.FuncionarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

	private final FuncionarioService funcionarioService;
	private final CoordenadorService coordenadorService;

	@GetMapping
	public ResponseEntity buscar(@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "cpf", required = false) String cpf,			
			@RequestParam(value = "coordenador", required = false) Integer idcoordenador) {
		Funcionario funcionarioFiltro = new Funcionario();
		funcionarioFiltro.setNome(nome);
		funcionarioFiltro.setCpf(cpf);
		

		if (idcoordenador != null) {
			Optional<Coordenador> coordenador = coordenadorService.obterPorId(idcoordenador);
			if (!coordenador.isPresent()) {
				return ResponseEntity.badRequest()
						.body("Não foi possível realizar a consulta. Coordenador não encontrado.");
			} else {
				funcionarioFiltro.setCoordenador(coordenador.get());
			}
		}
		List<Funcionario> funcionarios = funcionarioService.buscar(funcionarioFiltro);
		return ResponseEntity.ok(funcionarios);
	}

	@GetMapping("{id}")
	public ResponseEntity obterFuncionario(@PathVariable("id") Integer id) {
		return funcionarioService.obterPorId(id)
				.map( funcionario -> new ResponseEntity(converter(funcionario), HttpStatus.OK))
				.orElseGet( () -> new ResponseEntity(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity salvar(@RequestBody FuncionarioDTO dto) {
		try {
			Funcionario entidade = converter(dto);
			entidade = funcionarioService.salvar(entidade);
			return new ResponseEntity(entidade, HttpStatus.CREATED);
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("{id}")
	public ResponseEntity atualizar(@PathVariable("id") Integer id, @RequestBody FuncionarioDTO dto) {
		return funcionarioService.obterPorId(id).map(entity -> {
			try {
				Funcionario funcionario = converter(dto);
				funcionario.setId(entity.getId());
				funcionarioService.atualizar(funcionario);
				return ResponseEntity.ok(funcionario);
			} catch (RegraNegocioException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
		}).orElseGet(() -> new ResponseEntity("Funcionário não encontrado na base de dados.", HttpStatus.BAD_REQUEST));
	}

	@GetMapping("/detalhes/{id}")
	public ResponseEntity detalhes(@PathVariable("id") Integer id) {
		Optional<Funcionario> funcionario = funcionarioService.obterPorId(id);

		if (funcionario.isEmpty()) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(funcionario);
	}

	@DeleteMapping("{id}")
	public ResponseEntity deletar(@PathVariable("id") Integer id) {
		return funcionarioService.obterPorId(id).map(entidade -> {
			funcionarioService.deletar(entidade);

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}).orElseGet(() -> new ResponseEntity("Funcionário não encontrado na base de dados.", HttpStatus.BAD_REQUEST));
	}

	private FuncionarioDTO converter(Funcionario funcionario) {
		return FuncionarioDTO.builder().id(funcionario.getId()).nome(funcionario.getNome()).cpf(funcionario.getCpf())
				.foto(funcionario.getFoto())
				.coordenador(funcionario.getCoordenador().getId()).build();
	}

	private Funcionario converter(FuncionarioDTO dto) {
		Funcionario funcionario = new Funcionario();
		funcionario.setId(dto.getId());
		funcionario.setNome(dto.getNome());
		funcionario.setCpf(dto.getCpf());
		funcionario.setFoto(dto.getFoto());		

		Coordenador cordenador = coordenadorService.obterPorId(dto.getCoordenador())
				.orElseThrow(() -> new RegraNegocioException("Coordenador não encontrado para o Id informado."));

		funcionario.setCoordenador(cordenador);

		return funcionario;
	}
}
