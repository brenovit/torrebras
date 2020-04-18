package io.github.brenovit.rainbow.payload.usuario;

import java.util.Date;

import io.github.brenovit.rainbow.models.Status;
import lombok.Data;

@Data
public class UsuarioResponse {
	
	private Long id;
	private String usuario;
	private String email;	
	private String nome;	
	private String cpf;
	private Status status;
	//private Set<Permissao> permissoes = new HashSet<>();
	private Date dataCriacao;
}
