package io.github.brenovit.rainbow.exception;

import io.github.brenovit.rainbow.util.ErrorCode;

public class ValidationException extends GenericException{

	private static final long serialVersionUID = 1L;

	public ValidationException(ErrorCode errorCode, String extraMsg) {
		super(errorCode, extraMsg);
	}

}
