package com.wj.pms.controller;

import com.wj.pms.common.utils.Result;
import com.wj.pms.service.UserOperationRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by YoungSmith on 2018/7/30.
 */
@RestController
@RequestMapping("/api/logs")
public class UserOperationRecordControl {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserOperationRecordControl.class);
    @Autowired
    private UserOperationRecordService userOperationRecordService;

    @RequestMapping(value = "getUserOperationRecordInfos", method = RequestMethod.GET)
    @ResponseBody
    public Result getUserOperationRecordInfos() {
        try {
            return Result.success(userOperationRecordService.getUserOperationRecordInfos());
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }
}
