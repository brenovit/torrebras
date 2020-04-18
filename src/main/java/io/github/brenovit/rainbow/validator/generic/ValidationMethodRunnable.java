package io.github.brenovit.rainbow.validator.generic;

import io.github.brenovit.rainbow.exception.ValidationException;

@FunctionalInterface
public interface ValidationMethodRunnable extends Runnable {
		
	public default void execute() throws ValidationException {
		try {
			run();
		} catch (Exception exception) {
			ValidationException ex = (ValidationException) exception;
			throw ex;
		}
	}

}
