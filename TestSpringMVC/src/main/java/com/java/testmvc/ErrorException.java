package com.java.testmvc;

public class ErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ErrorException(int id) { 
		
		super("Eroor length > " + id);   
	}

}

