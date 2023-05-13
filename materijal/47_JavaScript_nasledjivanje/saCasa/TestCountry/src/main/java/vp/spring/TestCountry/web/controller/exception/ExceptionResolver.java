package vp.spring.TestCountry.web.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionResolver {

	@ExceptionHandler(ForbiddenException.class)
	public ResponseEntity forbiddenException(HttpServletRequest request, ForbiddenException exception) {
        return new ResponseEntity<>(exception, HttpStatus.FORBIDDEN);
    }

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity notFoundException(HttpServletRequest request, NotFoundException exception) {
		return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
	}
	
}
