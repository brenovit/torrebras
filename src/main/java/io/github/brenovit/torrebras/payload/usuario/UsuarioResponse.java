package io.github.brenovit.torrebras.payload.usuario;

import java.util.Date;

import io.github.brenovit.torrebras.models.Status;
import lombok.Data;

@Data
public class UsuarioResponse {
	
	private Long id;
	private String username;
	private String email;	
	private String nome;	
	private String cpf;
	private Status status;
	//private Set<Permissao> permissoes = new HashSet<>();
	private Date dataCriacao;
}
