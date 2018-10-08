package com.wj.pms.common;

import org.springframework.beans.BeanUtils;

public class BeanUtil {


    public static void copyProperties(Object sour, Object dist){
        BeanUtils.copyProperties(sour, dist);
    }
}
