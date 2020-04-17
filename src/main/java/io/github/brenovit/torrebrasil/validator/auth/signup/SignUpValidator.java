package io.github.brenovit.torrebrasil.validator.auth.signup;

import io.github.brenovit.torrebrasil.payload.auth.SignUpRequest;
import io.github.brenovit.torrebrasil.validator.generic.MultipleFieldValidator;

public class SignUpValidator extends MultipleFieldValidator<SignUpRequest> {

	@Override
	public void addValidationFor(SignUpRequest request) {
		add(() -> requiredField(request.getUsuario(), "usuario"));
		add(() -> requiredField(request.getSenha(), "senha"));
		add(() -> requiredField(request.getNome(), "nome"));
		add(() -> requiredField(request.getEmail(), "email"));
		
	}

}
