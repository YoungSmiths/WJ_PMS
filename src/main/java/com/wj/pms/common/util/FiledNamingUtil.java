package com.wj.pms.common.util;

public class FiledNamingUtil {
    /**
     * 将字符串a_bc_de 转换为 aBcDe
     * @param a_bc_de
     * @return
     */
    public static String toCamelString(String a_bc_de){
        String[] strings = a_bc_de.split("_");
        StringBuffer endStr =  new StringBuffer(strings[0]);
        for(int i = 1; i < strings.length; i++){
            String str = strings[i];
            endStr.append(str.substring(0,1).toUpperCase() + str.substring(1));
        }
        return endStr.toString();
    }
    public static void main(String args[]){
        String a_bc_de = FiledNamingUtil.toCamelString("paper_type");
        System.out.print(a_bc_de);
    }
}
