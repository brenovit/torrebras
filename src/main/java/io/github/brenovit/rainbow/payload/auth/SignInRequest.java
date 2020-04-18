package io.github.brenovit.rainbow.payload.auth;

import lombok.Data;

@Data
public class SignInRequest {
	private String usuario;
	private String senha;
}
