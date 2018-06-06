package com.wj.bean;

/**
 * Describe: 通用Bean
 *
 * @author YoungSmith
 * 18-6-4 下午10:40
 */
public class CommonBean extends Auditor{
    /**
     * 主键id
     */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public CommonBean setId(Integer id) {
        this.id = id;
        return this;
    }
}
