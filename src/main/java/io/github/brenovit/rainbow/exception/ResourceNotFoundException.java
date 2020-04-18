package io.github.brenovit.rainbow.exception;

import io.github.brenovit.rainbow.util.ErrorCode;

public class ResourceNotFoundException extends GenericException{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super(ErrorCode.RESOURCE_NOT_FOUND);
	}
	
	public ResourceNotFoundException(ErrorCode errorCode) {
		super(errorCode);
	}

}
