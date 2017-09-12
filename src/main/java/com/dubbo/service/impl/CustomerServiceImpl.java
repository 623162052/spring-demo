package com.dubbo.service.impl;

import com.dubbo.service.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 客户信息接口
 * Created by shiwx on 2017/6/15.
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

    /**
     * 查询客户信息
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> queryCustomerInfo() throws Exception {
        Map<String, Object> customerInfo = new HashMap<>();
        customerInfo.put("customName", "ooOoo");
        customerInfo.put("age", 18);
        return customerInfo;
    }

}
