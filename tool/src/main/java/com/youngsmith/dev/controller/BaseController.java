package com.youngsmith.dev.controller;

import com.alibaba.fastjson.JSONObject;
import com.youngsmith.dev.constants.ResponseCode;

/**
 * Describe: Controller
 *
 * @author YoungSmith
 * 18-6-13 下午9:30
 */
public class BaseController {

    protected AjaxResultDTO getResult(int code, String message, Object returnData, Object printData){
        if(printData instanceof Exception){
            ((Exception) printData).printStackTrace();
        } else {
            JSONObject.toJSONString(printData, true);
        }
       return new AjaxResultDTO(code, message, returnData);
    }

    protected AjaxResultDTO getSuccessResult(int code, String message, Object returnData){
        return getResult(code, message, returnData, null);
    }

    protected AjaxResultDTO getSuccessResult(int code, String message){
        return getSuccessResult(code, message, null);
    }

    protected AjaxResultDTO getSuccessResult(String message){
        return getSuccessResult(ResponseCode.SUCCESS, message);
    }

    protected AjaxResultDTO getSuccessResult(){
        return getSuccessResult("request success");
    }

    protected AjaxResultDTO getFailResult(int code, String message, Object returnData, Object printData){
        return getResult(code, message, returnData, printData);
    }
    protected AjaxResultDTO getFailResult(int code, String message, Object printData){
        return getFailResult(code, message, null, printData);
    }

    protected AjaxResultDTO getFailResult(int code, String message){
        return getFailResult(code, message, null);
    }

    protected AjaxResultDTO getFailResult(String message){
        return getFailResult(ResponseCode.REQUEST_FAIL, message);
    }

    protected AjaxResultDTO getFailResult(){
        return getFailResult("request failed");
    }
}
