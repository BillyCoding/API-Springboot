package com.gustavo.cursomc.resources.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FieldMessage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String field;
	private String msg;
	
	public FieldMessage() {}

	public FieldMessage(String field, String msg) {
		super();
		this.field = field;
		this.msg = msg;
	}
	

}
