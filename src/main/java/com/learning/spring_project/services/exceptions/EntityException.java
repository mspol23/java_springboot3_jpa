package com.learning.spring_project.services.exceptions;

public class EntityException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EntityException(String msg) {
		super(msg);
	}
}
