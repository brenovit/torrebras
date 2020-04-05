package io.github.brenovit.torrebras.payload.auth;

import lombok.Data;

@Data
public class SignInRequest {
	private String login;
	private String password;
}
