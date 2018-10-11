package com.wj.pms.bean;


public class OperationBean {

    private String operationCode;

    private String operationName;

    private String operationPersonName;

    private String operationPersonCode;

    private String startDate;

    private String endDate;

    private String device;

    private String departmentCode;

    private String note;

    public OperationBean() {
    }

    public OperationBean(String operationCode, String operationName, String operationPersonName, String operationPersonCode, String startDate, String endDate, String device, String departmentCode, String note) {
        this.operationCode = operationCode;
        this.operationName = operationName;
        this.operationPersonName = operationPersonName;
        this.operationPersonCode = operationPersonCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.device = device;
        this.departmentCode = departmentCode;
        this.note = note;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public OperationBean setOperationCode(String operationCode) {
        this.operationCode = operationCode;
        return this;
    }

    public String getOperationName() {
        return operationName;
    }

    public OperationBean setOperationName(String operationName) {
        this.operationName = operationName;
        return this;
    }

    public String getOperationPersonName() {
        return operationPersonName;
    }

    public OperationBean setOperationPersonName(String operationPersonName) {
        this.operationPersonName = operationPersonName;
        return this;
    }

    public String getOperationPersonCode() {
        return operationPersonCode;
    }

    public OperationBean setOperationPersonCode(String operationPersonCode) {
        this.operationPersonCode = operationPersonCode;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public OperationBean setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public OperationBean setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getDevice() {
        return device;
    }

    public OperationBean setDevice(String device) {
        this.device = device;
        return this;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public OperationBean setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
        return this;
    }

    public String getNote() {
        return note;
    }

    public OperationBean setNote(String note) {
        this.note = note;
        return this;
    }
}
