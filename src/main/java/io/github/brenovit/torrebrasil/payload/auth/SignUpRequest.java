package io.github.brenovit.torrebrasil.payload.auth;

import lombok.Data;
 
@Data
public class SignUpRequest {
	private String nome;
    private String usuario;
    private String senha;
    private String email;
}
