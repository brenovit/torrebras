package io.github.brenovit.torrebrasil.exception;

import io.github.brenovit.torrebrasil.util.ErrorCode;

public class ApplicationException extends GenericException{

	private static final long serialVersionUID = 1L;

	public ApplicationException(ErrorCode errorCode) {
		super(errorCode);
	}

}
