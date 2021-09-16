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
	// private String email;
	// private String cpf;
	// private String cep;
	// private Integer telefone;
	
	// pq um construtor vazio é importante?
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
