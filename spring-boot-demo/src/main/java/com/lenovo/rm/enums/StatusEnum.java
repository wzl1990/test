package com.lenovo.rm.enums;
																																																																																																																																																																																																																																																																																																																			
/**
 * 
 * 
 * @author zhenglong.wei
 *
 */
public enum StatusEnum {

	START("开始"), STOP("停止");

	StatusEnum(String message) {
		this.message = message;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}