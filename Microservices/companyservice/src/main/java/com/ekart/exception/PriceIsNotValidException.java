package com.ekart.exception;

public class PriceIsNotValidException extends RuntimeException{
	String msg;
	
	public PriceIsNotValidException(String msg)
	{
		this.msg=msg;
	}
	
	public String getMsg()
	{
		return msg;
	}
}
