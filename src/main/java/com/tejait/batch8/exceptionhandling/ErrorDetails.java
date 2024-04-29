package com.tejait.batch8.exceptionhandling;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
	Date timestamp;
	Integer status;
	String error;
	String message;
	String path;
	

}
