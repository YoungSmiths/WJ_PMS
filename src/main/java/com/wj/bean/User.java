package com.wj.bean;

import java.util.List;

/**
 * Describe: 用户类
 *
 * @author YoungSmith
 * 18-6-4 下午10:17
 */
public class User extends CommonBean{
    /**
     * 姓名
     */
    private String userName;
    /**
     * 密码
     */
    private String secret;
    /**
     * 手机号
     */
    private String telephone;
    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄
     */
    private int age;
    /**
     * 家庭地址
     */
    private String address;
    /**
     * 是否可配置
     */
    private boolean isConfiguration;
    /**
     * 所属部门
     */
    private List<Department> department;
    /**
     * 所拥有的角色，在部门拥有角色范围内
     */
    private List<Role> roles;

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getSecret() {
        return secret;
    }

    public User setSecret(String secret) {
        this.secret = secret;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public User setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public User setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public boolean isConfiguration() {
        return isConfiguration;
    }

    public User setConfiguration(boolean configuration) {
        isConfiguration = configuration;
        return this;
    }

    public List<Department> getDepartment() {
        return department;
    }

    public User setDepartment(List<Department> department) {
        this.department = department;
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public User setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }
}
