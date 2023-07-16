package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	   @ExceptionHandler(StockNotFoundException.class)
	   public ResponseEntity<MyErrorDetails>  productExceptionHandler(StockNotFoundException ex,WebRequest wr) {
		        
		   MyErrorDetails md=new MyErrorDetails();
		   md.setMessage(ex.getMessage());
		   md.setDetails(wr.getDescription(false));
		   return new ResponseEntity<>(md,HttpStatus.NOT_FOUND);
	   }
	   
	   @ExceptionHandler(LocationNotFoundException.class)
	   public ResponseEntity<MyErrorDetails>  productExceptionHandler(LocationNotFoundException ex,WebRequest wr) {
		        
		   MyErrorDetails md=new MyErrorDetails();
		   md.setMessage(ex.getMessage());
		   md.setDetails(wr.getDescription(false));
		   return new ResponseEntity<>(md,HttpStatus.NOT_FOUND);
	   }
}
