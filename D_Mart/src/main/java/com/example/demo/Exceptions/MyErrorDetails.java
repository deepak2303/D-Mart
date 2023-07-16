package com.example.demo.Exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyErrorDetails {

	private final LocalDateTime timestamp=LocalDateTime.now();
	private String message;
	private String Details;
	
}
