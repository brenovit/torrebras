package io.github.brenovit.torrebras.exception;

import io.github.brenovit.torrebras.util.ErrorCode;

public class ApplicationException extends GenericException{

	private static final long serialVersionUID = 1L;

	public ApplicationException(ErrorCode errorCode) {
		super(errorCode);
	}

}
