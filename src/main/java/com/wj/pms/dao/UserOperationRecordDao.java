package com.wj.pms.dao;

import com.wj.pms.common.model.UserOperationRecord;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by YoungSmith on 2018/7/30.
 */
public interface UserOperationRecordDao extends CrudRepository<UserOperationRecord, Long> {
}
