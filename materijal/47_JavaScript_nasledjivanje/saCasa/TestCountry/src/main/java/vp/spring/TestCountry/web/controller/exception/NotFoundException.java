package vp.spring.TestCountry.web.controller.exception;

public class NotFoundException extends RuntimeException {

	public NotFoundException() {
		
	}
	
	public NotFoundException(String message) {
		super(message);
	}
}
