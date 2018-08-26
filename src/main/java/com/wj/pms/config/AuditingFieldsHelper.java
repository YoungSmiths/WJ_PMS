package com.wj.pms.config;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Description 更新审计字段组件</br>
 * 目标对象dist 默认审计字段： createdBy  createdDate updatedBy updatedDate
 * @author Young Smith
 * Date 2018年8月21日 下午6:29:01
 */
@Component("auditingFieldsHelper")
public class AuditingFieldsHelper {

	private static final String USER_ID = "user";
	
//	public static void main(String[] args) {
//		BizInterviewQuestionTypeDO dist = new BizInterviewQuestionTypeDO();
//		new AuditingFieldsHelper().addAuditingFields(dist, BizInterviewQuestionTypeDO.class, "shiyang", new Date(), "shiyang", new Date());
//		System.out.println(JSONObject.toJSONString(dist));
//	}
	
	public void addAllAuditingFileds(Object dist, Class clz, HttpSession session){
		String user = getUser(session);
		Date date = new Date();
		addAuditingFields(dist, clz, user, date, user, date);
	}
	
	public void addUpdateAuditingFields(Object dist, Class clz, HttpSession session){
		String user = getUser(session);
		Date date = new Date();
		addAuditingFields(dist, clz, user, date, null, null);
	}
	
	public void addAuditingFields(Object dist, Class clz, String createBy, Date createDate, String updateBy, Date updateDate){
		try {
			Method createByMethod = clz.getMethod("setCreatedBy", String.class);
			createByMethod.setAccessible(true);
			createByMethod.invoke(dist, createBy);
			createByMethod.setAccessible(false);
			
			Method createDateMethod = clz.getMethod("setCreatedDate", Date.class);
			createDateMethod.setAccessible(true);
			createDateMethod.invoke(dist, createDate);
			createDateMethod.setAccessible(false);
			
			Method updateByMethod = clz.getMethod("setUpdatedBy", String.class);
			updateByMethod.setAccessible(true);
			updateByMethod.invoke(dist, updateBy);
			updateByMethod.setAccessible(false);
//			
			Method updateDateMethod = clz.getMethod("setUpdatedDate", Date.class);
			updateDateMethod.setAccessible(true);
			updateDateMethod.invoke(dist, updateDate);
			updateDateMethod.setAccessible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getUser(HttpSession session){
		return (String) session.getAttribute(USER_ID);
	}
}
