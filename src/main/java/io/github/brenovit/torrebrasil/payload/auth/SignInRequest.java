package io.github.brenovit.torrebrasil.payload.auth;

import lombok.Data;

@Data
public class SignInRequest {
	private String usuario;
	private String senha;
}
