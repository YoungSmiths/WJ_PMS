package com.wj.pms.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shiy on 2017/7/30.
 */
public class LogUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogUtil.class);

//    public enum LOGTYPE {
//        ADD, DELETE, UPDATE, LOGIN, LOGOUT, CONFIRM
//    }
//
//    public static void log4Add(UserOperationRecordService uors, String newContent, String target, User user) {
//        UserOperationRecord uor = new UserOperationRecord();
//        uor.setAction(LOGTYPE.ADD.name());
//        uor.setNewContent(newContent);
//        uor.setCreateTime(new Date());
//        uor.setUpdateTime(new Date());
//        uor.setUser(user);
//        uor.setTarget(target);
//        uor.setDeleted(false);
//        uors.addUserOperationRecordInfo(uor);
//    }
//
//    public static void Log4Update(UserOperationRecordService uors, String newContent, String oldContent, String target, User user, HttpServletRequest request) {
//        UserOperationRecord uor = new UserOperationRecord();
//        uor.setAction(LOGTYPE.UPDATE.name());
//        uor.setNewContent(newContent);
//        uor.setCreateTime(new Date());
//        uor.setUpdateTime(new Date());
//        uor.setUser(user);
//        uor.setTarget(target);
//        uor.setOldContent(oldContent);
//        uor.setDeleted(false);
//        uors.addUserOperationRecordInfo(uor);
//    }
//
//    public static void log(UserOperationRecordService uors, Date createTime, boolean deleted, Date updateTime, String action, String newContent, String oldContent, String target, User user) {
//        UserOperationRecord uor = new UserOperationRecord();
//        uor.setCreateTime(createTime);
//        uor.setDeleted(false);
//        uor.setUpdateTime(updateTime);
//        uor.setAction(action);
//        uor.setNewContent(newContent);
//        uor.setOldContent(oldContent);
//        uor.setTarget(target);
//        uor.setUser(user);
//        uors.addUserOperationRecordInfo(uor);
//    }
//
//    public static void log(UserOperationRecordService uors, Date createTime, boolean deleted, Date updateTime, String action, String newContent, String oldContent, String target, HttpSession session) {
//        UserOperationRecord uor = new UserOperationRecord();
//        uor.setCreateTime(createTime);
//        uor.setDeleted(false);
//        uor.setUpdateTime(updateTime);
//        uor.setAction(action);
//        uor.setNewContent(newContent);
//        uor.setOldContent(oldContent);
//        uor.setTarget(target);
//        uor.setUser((User) session.getAttribute("user"));
//        uors.addUserOperationRecordInfo(uor);
//    }
}
