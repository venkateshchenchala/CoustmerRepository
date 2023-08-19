package com.jsp.demo.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.demo.dto.ResponseStructure;
@RestControllerAdvice
public class ExceptionHandlerUtil
{
@ExceptionHandler(NoDataFoundException.class)
public ResponseEntity<ResponseStructure<String>>noNoDataFoundException(NoDataFoundException ie)
{
	ResponseStructure<String>re=new ResponseStructure<>();
	re.setStatuscode(HttpStatus.NOT_FOUND.value());
	re.setMessage("No data Found");
	re.setData(ie.getMessage());
	return new ResponseEntity<ResponseStructure<String>>(re,HttpStatus.NOT_FOUND);
	
}

}
