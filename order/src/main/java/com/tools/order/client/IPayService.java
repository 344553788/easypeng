package com.tools.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "payment")
public interface IPayService {

    /**
     * 调用支付服务
     */
    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    String pay();
}
