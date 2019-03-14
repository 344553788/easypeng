package com.tools.eureka.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Jeff
 * @Description: 注册中心监听事件
 */
@Configuration
@Slf4j
public class EurekaEvent implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(applicationEvent instanceof EurekaInstanceCanceledEvent){
            //服务断开连接时
            log.info(((EurekaInstanceCanceledEvent) applicationEvent).getAppName() +"服务断开连接了！");
        }
        if(applicationEvent instanceof EurekaInstanceRegisteredEvent){
            log.info(((EurekaInstanceRegisteredEvent) applicationEvent).getInstanceInfo().getAppName()+"服务注册了！");
        }
        if(applicationEvent instanceof EurekaInstanceRenewedEvent){
            log.info(((EurekaInstanceRenewedEvent) applicationEvent).getAppName()+"服务Renewed了！");
        }
        if(applicationEvent instanceof EurekaServerStartedEvent){
            log.info("注册中心服务Started！！");
        }
        if(applicationEvent instanceof EurekaRegistryAvailableEvent){
            //服务可用
            log.info("注册中心服务可用！");
        }
    }
}
