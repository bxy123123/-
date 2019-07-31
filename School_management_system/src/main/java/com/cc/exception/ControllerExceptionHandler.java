package com.cc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.util.NoteResult;


@ControllerAdvice
public class ControllerExceptionHandler {
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public NoteResult handleException(Exception e){
		System.out.println("exception");
		e.printStackTrace();
		return new NoteResult(e);
	}	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public NoteResult handleException(RuntimeException e){
		System.out.println("runtime exception");
		e.printStackTrace();
		return new NoteResult(e);
	}
}








