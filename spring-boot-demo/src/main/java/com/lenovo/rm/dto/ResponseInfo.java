package com.lenovo.rm.dto;

import java.io.Serializable;

public class ResponseInfo implements Serializable {

	private static final long serialVersionUID = 6180026101789656042L;

	private boolean state;

	private Integer code=200;

	private String message;

	public ResponseInfo() {

	}

	public ResponseInfo(boolean state, Integer code, String message) {
		this.state = state;
		this.code = code;
		this.message = message;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}