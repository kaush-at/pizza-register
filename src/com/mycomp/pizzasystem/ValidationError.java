package com.mycomp.pizzasystem;

public class ValidationError extends Exception {

	/**
	 * What is this???
	 * The serializable class ValidationError does not declare a static final serialVersionUID field of type long
	 */
	private static final long serialVersionUID = 1L;

	public ValidationError(String message) {
		super(message);
		
	}
}
