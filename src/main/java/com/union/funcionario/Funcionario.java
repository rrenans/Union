package com.union.funcionario;

import java.time.LocalDate;

import com.union.pessoa.Pessoa;

public class Funcionario extends Pessoa {
	private String cargo;

	public Funcionario(Long id, String nome, String email, String cpf, LocalDate dataNascimento, String telefone,
			Integer cep, String cargo) {
		super(id, nome, email, cpf, dataNascimento, telefone, cep);
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Funcionario [cargo=" + cargo + "]";
	}
	
}
