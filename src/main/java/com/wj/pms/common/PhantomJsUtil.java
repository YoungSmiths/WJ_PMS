package com.wj.pms.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;

/**
 * Created by YoungSmith on 2018/8/13.
 */
public class PhantomJsUtil {
    private static final Logger logger = LoggerFactory.getLogger(PhantomJsUtil.class);

    private WebDriver webDriver = new PhantomJSDriver();

    private static PhantomJsUtil instance = new PhantomJsUtil();

    private PhantomJsUtil() {
    }

    static {
        String osname = System.getProperties().getProperty("os.name");
        if (osname.equals("Linux")) {//判断系统的环境win or Linux
            System.setProperty("phantomjs.binary.path", "/usr/bin/phantomjs");
        } else {
            System.setProperty("phantomjs.binary.path", "./phantomjs/win/phantomjs.exe");//设置PhantomJs访问路径
        }
    }

    public static WebDriver getDriver() {
        return instance.webDriver;
    }

    @PreDestroy
    public static void quit() {
        instance.webDriver.quit();
        logger.info("PhantomJSDriver Destory!!!");
    }

}
