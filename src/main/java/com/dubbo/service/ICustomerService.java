package com.dubbo.service;

import java.util.Map;

/**
 * 客户信息接口
 * Created by shiwx on 2017/6/15.
 */
public interface ICustomerService {

    /**
     * 查询客户信息
     * @return
     * @throws Exception
     */
    Map<String, Object> queryCustomerInfo() throws Exception;

}
