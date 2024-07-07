package com.ekart.exception;

public class AgeIsNotValidException extends RuntimeException{
	String msg;
	
	public AgeIsNotValidException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
		
}
