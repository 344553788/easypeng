微服务拆分实例
简介

使用SpringCloud + Gradle构建的微服务项目
版本如下：
SpringCloud ： Finchley.SR1
SpringBoot ： 2.1.3.RELEASE
Gradle ： 4.8
这个项目用于讲述微服务拆分的例子，没有实现具体的数据库操作，只是为了展示拆分后的效果，用于演示。
分支说明

master：用于拆分说明，并作为基本案例
distributed-transaction：mq最终一致性案例说明
dockerization：用于容器化案例说明
项目结构
目录 	名称 	访问地址
eureka 	注册中心 	http://127.0.0.1:8885
zuul 	网关+路由 	http://127.0.0.1:8881/order/buy http://127.0.0.1:8881/payment/pay
zipkin 链路追踪　　http://127.0.0.1:9411/zipkin/
turbine 断路器聚合监控  http://127.0.0.1:8886/hystrix
order 	订单服务 	http://127.0.0.1:8884/buy
payment	支付服务 	http://127.0.0.1:8883/pay
启动顺序

注册中心 -> 网关 -> 订单 -> 支付 ->链路追踪和断路器聚合监控
服务顺序

通过网关访问：http://127.0.0.1:8769/8881/order/buy
用户购买行为 -> 通过网关(gateway) -> 订单(order)服务 -> 支付(pay)服务
具体完整项目说明讲解

