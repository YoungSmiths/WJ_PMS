package com.wj.pms.common;

/**
 * Created by YoungSmith on 2018/3/10.
 */
public class FileContrast {
    private String cliPath;
    private String cliMD5;
    private String serMD5;
    private String serPath;
    private boolean status;


    public String getCliPath() {
        return cliPath;
    }

    public void setCliPath(String cliPath) {
        this.cliPath = cliPath;
    }

    public String getCliMD5() {
        return cliMD5;
    }

    public void setCliMD5(String cliMD5) {
        this.cliMD5 = cliMD5;
    }

    public String getSerMD5() {
        return serMD5;
    }

    public void setSerMD5(String serMD5) {
        this.serMD5 = serMD5;
    }

    public String getSerPath() {
        return serPath;
    }

    public void setSerPath(String serPath) {
        this.serPath = serPath;
    }

    public boolean isStatus() {

        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
