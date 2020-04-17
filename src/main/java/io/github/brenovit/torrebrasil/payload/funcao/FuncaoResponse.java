package io.github.brenovit.torrebrasil.payload.funcao;

import java.util.Set;

import io.github.brenovit.torrebrasil.models.Colaborador;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class FuncaoResponse{
	private Long id;
	private String nome;
	private Set<Colaborador> funcoes;
}
