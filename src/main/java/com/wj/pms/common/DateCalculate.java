package com.wj.pms.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by YoungSmith on 2018/7/26.
 */

public class DateCalculate {
    static Logger logger = LoggerFactory.getLogger(DateCalculate.class);

    /**
     * 切割时间段
     * 支持每月/每天/每小时/每分钟交易金额(可分应用平台统计)
     *
     * @param dateType 日期类型 M(每月)/D(每天)/H(每小时)/N(每分钟)
     *                 M：日期段应为当年月份以内 且 日期必须是01 时分秒必须是 00:00:00  例如：2016-06-01 00:00:00 2016-10-01 00:00:00
     *                 D: 日期段应为一月内 且 日期应当是01或31  时分秒必须是 00:00:00   例如：2016-10-01 00:00:00 2016-10-31 00:00:00
     *                 H：日期段应为一天内  且 时分秒必须是 00:00:00   例如：2016-10-01 00:00:00 2016-10-02 00:00:00
     *                 N：日期段应为一小时内  日期应相同 且 分秒必须是 xx:00:00   例如：2016-10-02 22:00:00 2016-10-02 23:00:00
     * @param dateType 交易类型 M/D/H/T -->每月/每天/每小时/每分钟
     * @param start    yyyy-MM-dd HH:mm:ss
     * @param end      yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static List<Date> cutDate(String dateType, int typeCount, String start, String end) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dBegin = sdf.parse(start);
            Date dEnd = sdf.parse(end);
            return findDates(dateType, typeCount, dBegin, dEnd);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 分割时间段
     * @param dateType
     * @param typeCount
     * @param dBegin
     * @param dEnd
     * @return
     * @throws Exception
     */
    public static List<Date> findDates(String dateType, int typeCount, Date dBegin, Date dEnd) throws Exception {
        List<Date> listDate = new ArrayList<>();
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dBegin);
        listDate.add(calBegin.getTime());
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);
        while (calEnd.after(calBegin)) {
            switch (dateType) {
                case "M":
                    calBegin.add(Calendar.DAY_OF_YEAR, typeCount);//Calendar.MONTH
                    break;
                case "D":
                    calBegin.add(Calendar.DAY_OF_YEAR, typeCount);
                    break;
                case "H":
                    calBegin.add(Calendar.HOUR, typeCount);
                    break;
                case "T":
                    calBegin.add(Calendar.MINUTE, typeCount);
                    break;
                default:
                    return null;
            }
            if (calEnd.after(calBegin))
                listDate.add(calBegin.getTime());
            else {
                listDate.add(calEnd.getTime());
                break;
            }
        }
        return listDate;
    }

    public static Date getLastDate(String dateType, int typeCount, Date start) {
        Calendar begin = Calendar.getInstance();
        begin.setTime(start);
        switch (dateType) {
            case "M":
                begin.add(Calendar.MONTH, -typeCount);
                break;
            case "D":
                begin.add(Calendar.DAY_OF_YEAR, -typeCount);
                break;
            case "H":
                begin.add(Calendar.HOUR, -typeCount);
                break;
            case "T":
                begin.add(Calendar.MINUTE, -typeCount);
                break;
            default:
                return null;
        }
        return begin.getTime();
    }

//    public static void main(String[] args) throws Exception {
//        String start = "2016-10-02 12:00:00";
//        String end = "2016-10-02 23:00:00";
//        List<Date> list = cutDate("H", 2, start, end);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("-------------------");
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(list.get(i)));
//            System.out.println(list.get(i).getMonth()+1 +"月");
//            System.out.println(list.get(i).getDate()+"日");
//            System.out.println(list.get(i).getTime());
//            System.out.println(list.get(i).getMinutes());
//            System.out.println(list.get(i));
//            if (i < list.size() - 2)
//                System.out.println(list.get(i + 1));
//            else {
//                System.out.println(list.get(i + 1));
//                i++;
//            }
//        }

//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(findEndDate("M", start, end)));
//    }
}
