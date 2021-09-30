package com.union.repository;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.union.funcionario.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
	/*
	Optional<Funcionario>pegarFuncionarioPeloNome(String nome);
	
	Funcionario pegarFuncionarioPeloId(Integer id);
	*/
}
