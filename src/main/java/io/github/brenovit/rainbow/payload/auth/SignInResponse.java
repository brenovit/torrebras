package io.github.brenovit.rainbow.payload.auth;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignInResponse {	
	private String token;
	private String type = "Bearer";
	private String username;
	private String email;
	private List<String> permissions;

	public SignInResponse(String accessToken, String username, String email, List<String> permissions) {
		this.token = accessToken;
		this.username = username;
		this.email = email;
		this.permissions = permissions;
	}
	
}
