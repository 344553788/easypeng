package com.tools.payment.controller;

import com.tools.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单
 * @author LinkinStar
 */
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/pay")
    public Boolean pay(){
        return paymentService.pay();
    }
}