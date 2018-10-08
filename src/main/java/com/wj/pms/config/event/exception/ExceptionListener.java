package com.wj.pms.config.event.exception;

import com.wj.pms.mybatis.entity.ExceptionInfo;
import com.wj.pms.mybatis.mapper.ExceptionInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.common.eventbus.Subscribe;
/**
 * 异常监听</br>
 * @author YoungSmith
 * @date 2018年8月8日 下午2:51:37
 */
@Component("exceptionListener")
public class ExceptionListener {
  
 	@Autowired
 	private ExceptionInfoMapper exceptionInfoMapper;
    
 	@Subscribe  
    public void listen(ExceptionInfo exception) {
    		exceptionInfoMapper.insert(exception);
    }  
}
