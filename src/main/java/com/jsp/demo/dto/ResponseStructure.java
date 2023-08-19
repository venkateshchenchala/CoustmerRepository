package com.jsp.demo.dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class ResponseStructure<T> 
{
private Integer statuscode;
private T data;
private String message;
private LocalDateTime timeStamp;
}
