package com.wj.pms.config.aspect.support;

import com.wj.pms.common.enums.BaseResponseCodeEnum;
import org.springframework.util.StringUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ParamCheckHelper {
	@SuppressWarnings("rawtypes")
	public static void checkParamNull(Object obj) throws NotExceptNullException{
		try {
			checkNull(obj);
			checkString(obj);
			if(obj instanceof Map){
				checkMap((Map)obj);
			}
		} catch (NotExceptNullException e) {
			throw e;
		} catch (Exception e) {
			// do nothing
		}
	}
	
	@SuppressWarnings("rawtypes")
	private static void checkMap(Map map) throws NotExceptNullException{
		Iterator ite = map.entrySet().iterator();
		while(ite.hasNext()){
			Object next = ite.next();
			checkNull(next);
			checkString(next);
			checkString(((Entry)next).getValue());
			if(next instanceof Map){
				checkMap((Map)next);
			}
		}
	}

	private static void checkNull(Object next) throws NotExceptNullException {
		if(next == null){
			throw new NotExceptNullException(BaseResponseCodeEnum.NO_EXPECTED_NULL, next);
		}
	}
	
	private static void checkString(Object obj) throws NotExceptNullException {
		if(obj instanceof String && StringUtils.isEmpty(obj)){
			throw new NotExceptNullException(BaseResponseCodeEnum.NO_EXPECTED_NULL, obj);
		}
	}
}
