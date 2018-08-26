package com.wj.pms.config.event.exception;

import com.wj.pms.mybatis.mapper.ExceptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.wj.pms.mybatis.entity.Exception;
import com.google.common.eventbus.Subscribe;
/**
 * 异常监听</br>
 * @author YoungSmith
 * @date 2018年8月8日 下午2:51:37
 */
@Component("exceptionListener")
public class ExceptionListener {
  
 	@Autowired
 	private ExceptionMapper exceptionMapper;
    
 	@Subscribe  
    public void listen(ExceptionEvent event) {  
 		Exception exception = event.getExceptionDO();
    	if(exception != null)
    		exceptionMapper.insert(exception);
    }  
}
