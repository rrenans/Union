package com.union.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO {

	private Integer id;
	private String nome;	
	private String cpf;
	private String foto;	
	private Integer coordenador;
}
