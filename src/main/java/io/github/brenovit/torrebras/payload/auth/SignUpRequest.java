package io.github.brenovit.torrebras.payload.auth;

import lombok.Data;
 
@Data
public class SignUpRequest {
    private String username;
    private String email;
    private String senha;
    private String nome;
}
