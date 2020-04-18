package io.github.brenovit.rainbow.payload.colaborador;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ColaboradorRequest {
	private Long funcaoId;
	private String nome;
	private String matricula;
	private String foto;
	private String mensagem;	
	private List<Long> cursos = new ArrayList<>();
}
