package com.jsp.demo.ExceptionHandler;

public class NoDataFoundException extends RuntimeException
{
private String message="Their is no data of user request";

public String message()
{
	return message;
}
public NoDataFoundException(String message)
{
	this.message=message;
}
public NoDataFoundException()
{

}
@Override
	public void printStackTrace() {
		
		super.printStackTrace();
	}
}
