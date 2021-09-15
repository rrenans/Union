package com.union.coordenador;

public class Coordenador {

	private Integer id;
	private String nome;
	// private String email;
	// private String cpf;
	// private String cep;
	// private Integer telefone;
	
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
	
}
