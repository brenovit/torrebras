package io.github.brenovit.rainbow.validator.auth.sigin;

import io.github.brenovit.rainbow.payload.auth.SignInRequest;
import io.github.brenovit.rainbow.validator.generic.MultipleFieldValidator;

public class SignInValidator extends MultipleFieldValidator<SignInRequest> {

	@Override
	public void addValidationFor(SignInRequest request) {
		add(() -> requiredField(request.getUsuario(), "usuario"));
		add(() -> requiredField(request.getSenha(), "senha"));		
	}

}
