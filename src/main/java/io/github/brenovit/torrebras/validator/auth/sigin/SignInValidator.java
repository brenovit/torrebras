package io.github.brenovit.torrebras.validator.auth.sigin;

import io.github.brenovit.torrebras.payload.auth.SignInRequest;
import io.github.brenovit.torrebras.validator.generic.MultipleFieldValidator;

public class SignInValidator extends MultipleFieldValidator<SignInRequest> {

	@Override
	public void addValidationFor(SignInRequest request) {
		add(() -> requiredField(request.getUsuario(), "usuario"));
		add(() -> requiredField(request.getSenha(), "senha"));		
	}

}
