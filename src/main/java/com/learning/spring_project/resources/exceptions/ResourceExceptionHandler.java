package com.learning.spring_project.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.learning.spring_project.services.exceptions.DataBaseException;
import com.learning.spring_project.services.exceptions.EntityException;
import com.learning.spring_project.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest req){
		String error = "Resource not found.";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), req.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> dataBaseIntegrity(DataBaseException e, HttpServletRequest req){
		String error = "Referential integrity constraint violation";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), req.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	// PODERIA TER UTILIZADO O ResourceNotFountException NESTE CASO.
	@ExceptionHandler(EntityException.class)
	public ResponseEntity<StandardError> entityNotFound(EntityException e, HttpServletRequest req){
		String error = "Entity not found.";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), req.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
