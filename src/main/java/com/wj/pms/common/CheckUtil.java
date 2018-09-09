package com.wj.pms.common;

import java.util.List;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-9-2 下午4:48
 */
public class CheckUtil {

    public static boolean checkListNull(List<Object> list){
        return list != null && list.size() != 0;
    }
}
