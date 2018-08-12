package com.wj.pms.mybatis.mapper.self;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-8-12 上午7:53
 */
public class BaseService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseService.class);

    @Autowired
    protected PmsDao pmsDao;
}
