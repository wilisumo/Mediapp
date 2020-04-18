package com.bisoft.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController //manejo de excepciones como respuesta a servicios REST
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
	//Manejar un metodo para manejar la excepcion ModeloNotFound recibe la peticion del cliente y
	//construye una respuesta basado en Exception Response.
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(ModeloNotFoundException ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(ModeloNotFoundException.class)
	public final ResponseEntity<Object> manejarModeloExceptiones(ModeloNotFoundException ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex
			,HttpHeaders headers,HttpStatus status, WebRequest request){
		String error = "";
		for(ObjectError er: ex.getBindingResult().getAllErrors() ) {
			error+=er.getObjectName();
		}
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),"Validacion fallida", error);
		return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
}
