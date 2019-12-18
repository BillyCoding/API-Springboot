package com.gustavo.cursomc.resources.exception;

import java.io.Serializable;

import lombok.Data;

public @Data class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer status;
	private String msg;
	private Long timeStamp;

	public StandardError(Integer status, String msg, Long timeStamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}
}
