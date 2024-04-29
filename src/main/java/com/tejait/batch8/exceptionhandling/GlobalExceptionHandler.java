package com.tejait.batch8.exceptionhandling;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(InvalidIdException.class) //specific Exceptions
	public ResponseEntity<ErrorDetails>InvalidIdException(HttpServletRequest request){
		ErrorDetails errorDtls=new ErrorDetails(new Date(),404,"Invalid Id","your requsted id not available",request.getRequestURI());
		return new ResponseEntity<>(errorDtls,HttpStatus.BAD_REQUEST);		
	}
	@ExceptionHandler(InsuffiecientBalanceException.class)//specific Exceptions
	public ResponseEntity<ErrorDetails>insuffiecientBalanceException(HttpServletRequest request){
		ErrorDetails errorDtls=new ErrorDetails(new Date(),404,"Insuufiecient Balance","Top up to use",request.getRequestURI());
		return new ResponseEntity<>(errorDtls,HttpStatus.BAD_REQUEST);		
	}
	@ExceptionHandler(InvalidCredentialsException.class)//specific Exceptions
	public ResponseEntity<ErrorDetails>invalidCredentialsException(HttpServletRequest request){
		ErrorDetails errorDtls=new ErrorDetails(new Date(),404,"Credentials not found","username or password incorrect",request.getRequestURI());
		return new ResponseEntity<>(errorDtls,HttpStatus.BAD_REQUEST);		
	}
	@ExceptionHandler(Exception.class)//Common Exceptions
	public ResponseEntity<ErrorDetails>customException(HttpServletRequest request){
		ErrorDetails errorDtls=new ErrorDetails(new Date(),404,"not found","Data not found",request.getRequestURI());
		return new ResponseEntity<>(errorDtls,HttpStatus.BAD_REQUEST);		
	}
	
	  @ExceptionHandler(MailAlreadyExistException.class)
	  public
	  ResponseEntity<ErrorMessage> mailAlreadyExistException(MailAlreadyExistException request){
		  ErrorMessage errorMsg=new ErrorMessage("mail AlreadyExist"); 
		  return new ResponseEntity<>(errorMsg,HttpStatus.BAD_REQUEST);
		  }
	  

	  @ExceptionHandler(AppIdNotValidException.class)
	  public
	  ResponseEntity<ErrorMessage> appIdNotValidExceptionn(AppIdNotValidException request){
		  ErrorMessage errorMsg=new ErrorMessage("Appid not exist"); 
		  return new ResponseEntity<>(errorMsg,HttpStatus.BAD_REQUEST);
		  }
	  
	  @ExceptionHandler(DataNotFoundException.class)
	  public
	  ResponseEntity<ErrorMessage> dataNotFoundException(DataNotFoundException request){
		  ErrorMessage errorMsg=new ErrorMessage("Data not found"); 
		  return new ResponseEntity<>(errorMsg,HttpStatus.BAD_REQUEST);
		  }
	  @ExceptionHandler(MobileAlreadyexistException.class) 
	  public ResponseEntity<ErrorMessage>mobilealreayExixtException(MobileAlreadyexistException request){
		  ErrorMessage errorMsg=new ErrorMessage("MobilenumberAlready Exist");
		  return new ResponseEntity<>(errorMsg,HttpStatus.BAD_REQUEST); }
	 
	
	@ExceptionHandler(DataAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> dataAleadyExist(HttpServletRequest request){
		
		ErrorDetails errorDtls=new ErrorDetails(new Date(),404,"Data already exixt","Mail_id or Mobile number xexist",request.getRequestURI());
		return new ResponseEntity<>(errorDtls,HttpStatus.BAD_REQUEST);
	}
}
