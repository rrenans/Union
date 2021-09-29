package com.union.coordenador;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Entidade para o banco de dados
@Table(name = "Coordenador") // Mostra que a minha classe coordenador é uma tabela no banco de dados
public class Coordenador {

	@Id // Primary key do banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) // seria o Auto increment do nosso banco
	private Integer id;
	
	@Column // Nome é uma coluna
	private String nome;
	private String email;
	private String cpf;
	private String cep;
	private Integer telefone;
	
	public Coordenador() {
		super();
	}
	
	public Coordenador(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	
	
	
}
