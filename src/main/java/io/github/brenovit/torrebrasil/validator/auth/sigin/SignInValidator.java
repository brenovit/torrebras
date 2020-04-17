package io.github.brenovit.torrebrasil.validator.auth.sigin;

import io.github.brenovit.torrebrasil.payload.auth.SignInRequest;
import io.github.brenovit.torrebrasil.validator.generic.MultipleFieldValidator;

public class SignInValidator extends MultipleFieldValidator<SignInRequest> {

	@Override
	public void addValidationFor(SignInRequest request) {
		add(() -> requiredField(request.getUsuario(), "usuario"));
		add(() -> requiredField(request.getSenha(), "senha"));		
	}

}
