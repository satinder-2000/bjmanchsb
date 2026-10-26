package org.bjm;

public class LoginException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public LoginException(String message) {
		this.message=message;
	}
}
