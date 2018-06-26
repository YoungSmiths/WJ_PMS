package com.wj.pms.service;

import com.wj.pms.common.model.UserOperationRecord;
import com.wj.pms.dao.UserOperationRecordDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungSmith on 2018/7/30.
 */
@Service
public class UserOperationRecordService {
    protected static final Logger LOGGER = LoggerFactory.getLogger(UserOperationRecordService.class);
    @Autowired
    private UserOperationRecordDao userOperationRecordDao;

    public List<UserOperationRecord> getUserOperationRecordInfos() {
        Iterable<UserOperationRecord> all = userOperationRecordDao.findAll();
        List<UserOperationRecord> uors = new ArrayList<>();
        for (UserOperationRecord uor : all) {
            uors.add(uor);
        }
        uors.sort((o1, o2) -> -o1.compareTo(o2));
        return uors;
    }

    public void addUserOperationRecordInfo(UserOperationRecord uor) {
        try {
            userOperationRecordDao.save(uor);
        } catch (Exception e) {
            LOGGER.debug("add log has a error," + e);
        }
    }
}
