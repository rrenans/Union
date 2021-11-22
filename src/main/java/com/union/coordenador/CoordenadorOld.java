package com.union.coordenador;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
// import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.union.model.entity.Funcionario;
import com.union.model.entity.Usuario;

import lombok.*;


@Entity // Entidade para o banco de dados
@Table(name = "Coordenador") // Mostra que a minha classe coordenador é uma tabela no banco de dados
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoordenadorOld {

	@Id // Primary key do banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) // seria o Auto increment do nosso banco
	private Integer id;
	
	@Column // Nome é uma coluna
	private String nome;
	private String email;
	private String cpf;
	private String cep;
	private Integer telefone;
	
	//@OneToOne
	//@JoinColumn(name = "usuarioId", referencedColumnName = "id")
	//private Usuario usuario;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "coordenadorId", referencedColumnName = "id")
	private List<Funcionario> funcionario;	

	public CoordenadorOld(Integer id, String nome, String email, String cpf, String cep, Integer telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.cep = cep;
		this.telefone = telefone;
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

	public List<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}	
}
