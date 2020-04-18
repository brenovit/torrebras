package io.github.brenovit.rainbow.validator;

import io.github.brenovit.rainbow.payload.auth.SignInRequest;
import io.github.brenovit.rainbow.payload.auth.SignUpRequest;
import io.github.brenovit.rainbow.validator.auth.sigin.SignInValidator;
import io.github.brenovit.rainbow.validator.auth.signup.SignUpValidator;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidatorRequestFacade {
	private static final SignInValidator signInValidator = new SignInValidator();
	private static final SignUpValidator signUpValidator = new SignUpValidator();
	
	@SneakyThrows	
	public void validate(SignInRequest request) {
		signInValidator.validate(request);
	}
	
	@SneakyThrows	
	public void validate(SignUpRequest request) {
		signUpValidator.validate(request);
	}	
}
