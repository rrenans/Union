package com.union.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.union.model.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

}
