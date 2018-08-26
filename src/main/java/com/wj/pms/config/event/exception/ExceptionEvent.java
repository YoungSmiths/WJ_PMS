package com.wj.pms.config.event.exception;

import com.wj.pms.mybatis.entity.Exception;

public class ExceptionEvent {
	 	private final Exception exception;
	    public ExceptionEvent(Exception exception) {
	        this.exception = exception;  
	        System.out.println("event exception:" + exception);  
	    }  
	    public Exception getExceptionDO() {
	        return exception;  
	    } 
}
