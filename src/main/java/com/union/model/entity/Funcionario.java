package com.union.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Funcionario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nome;
	private String cpf;
	private String cep;
	private Integer telefone;
	
	// private Integer codigoPerfil;

	// @ManyToOne
	// @JoinColumn(name = "coordenadorId", referencedColumnName = "id")
	// private Coordenador coordenador;
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(Integer id, String nome, String cpf, String cep, Integer telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.cep = cep;
		this.telefone = telefone;
		// this.codigoPerfil = codigoPerfil;
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

	/*
	public Integer getCodigoPerfil() {
		return codigoPerfil;
	}

	public void setCodigoPerfil(Integer codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}
	*/
	
	
}
