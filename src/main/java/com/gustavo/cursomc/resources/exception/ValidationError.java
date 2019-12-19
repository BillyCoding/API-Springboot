package com.gustavo.cursomc.resources.exception;

import java.util.ArrayList;
import java.util.List;


public class ValidationError extends StandardError{
	private static final long serialVersionUID = 1L;

	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}
	
	private List<FieldMessage> erros = new ArrayList<>();

	public void addError(String field, String msg) {
		erros.add(new FieldMessage(field, msg));
	}
	
	
}
