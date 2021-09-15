package com.union.coordenador;
/*
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
*/
// @Entity
// @Table(name = "Coordenador")
public class Coordenador {

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
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
