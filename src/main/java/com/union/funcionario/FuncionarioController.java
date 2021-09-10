package com.union.funcionario;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "funcionario")
public class FuncionarioController {

	@GetMapping
	public List<Funcionario> hello() {
		return List.of(
			new Funcionario(
				1L, 
				"renan", 
				"renan@email",
				"123.456.789-00", 
				LocalDate.of(2004, Month.FEBRUARY, 29), 
				"99999-9999", 
				12345678, 
				"Agente"
			)
		);
	}
}
