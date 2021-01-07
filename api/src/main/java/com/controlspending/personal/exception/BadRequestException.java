package com.controlspending.personal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{

private static final long serialVersionUID = 1L;
	
private List<FieldError> errors = new ArrayList<>();

public BadRequestException() {
	super();
}

public BadRequestException(String msg) {
	super(msg);
}

public BadRequestException(List<FieldError> errors) {
	super();
	this.errors = errors;
}

public List<FieldError> getErrors() {
	return errors;
}

public void setErrors(List<FieldError> errors) {
	this.errors = errors;
}
}
