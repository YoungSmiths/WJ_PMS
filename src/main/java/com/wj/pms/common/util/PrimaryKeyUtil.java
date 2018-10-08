package com.wj.pms.common.util;

import com.wj.pms.common.enums.OrderIdTypeEnum;

import java.math.BigDecimal;

public class PrimaryKeyUtil {

    public static BigDecimal generateID(OrderIdTypeEnum type, String parentID) {
//        String id = DateUtil.formatLocalDateTimeToString(LocalDateTime.now(), DateUtil.TIME_PATTERN_MILLISECOND1);
////        String a = UUID.randomUUID().toString();
////        if(StringUtils.isEmpty(parentID))
////            return id + a.substring(a.length() - 5, a.length());
////        else{
////            assert id != null;
////            return id + type.getValue() + a.substring(a.length() - 3, a.length());
////        }
        return new BigDecimal(System.currentTimeMillis());
    }
}
