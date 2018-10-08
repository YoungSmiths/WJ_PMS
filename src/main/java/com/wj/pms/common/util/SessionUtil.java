package com.wj.pms.common.util;

import javax.servlet.http.HttpSession;

public class SessionUtil {
    public static void setAttr(HttpSession session,String key, Object obj){
        session.setAttribute(key, obj);
    }

    public static Object getAttr(HttpSession session, String key){
        return session.getAttribute(key);
    }
}
