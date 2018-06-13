package com.youngsmith.dev.controller;

import com.alibaba.fastjson.JSONObject;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-6-13 下午9:30
 */
public class BaseController {
    protected AjaxResultDTO getSuccessResult(String code, String message, Object returnData, Object printData){
        if(printData instanceof Exception){
            ((Exception) printData).printStackTrace();
        } else {
            JSONObject.toJSONString(printData, true);
        }
       return new AjaxResultDTO(code, message, returnData);
    }

    protected AjaxResultDTO getSuccessResult(String code, String message, Object returnData){
        return getSuccessResult(code, message, returnData, null);
    }

    protected AjaxResultDTO getSuccessResult(String code, String message){
        return getSuccessResult(code, message, null, null);
    }

    protected AjaxResultDTO getSuccessResult(String message){
        return getSuccessResult("200", message, null, null);
    }
}
