package com.controlspending.personal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

private static final long serialVersionUID = 1L;

	public NotFoundException() {
		super();		
	}
	
	public NotFoundException(String campo) {
		super(campo);		
	}
}
