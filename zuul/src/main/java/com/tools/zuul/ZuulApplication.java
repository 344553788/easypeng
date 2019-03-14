package com.tools.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
/**
 * 添加hystrix监控,去掉该注释用Turbine
 */
@EnableHystrix
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

}