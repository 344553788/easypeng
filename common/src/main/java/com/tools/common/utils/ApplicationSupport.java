package com.tools.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author jeff
 * @Date 2018/12/12 11:45 AM
 * @Description TODO
 * @Version 0.1
 */
@Component
public class ApplicationSupport implements DisposableBean, ApplicationContextAware {

  private static ApplicationContext applicationContext;
  // 获取配置文件参数值
  public static String getParamVal(String paramKey){
    return applicationContext.getEnvironment().getProperty(paramKey);
  }

  // 获取bean对象
  public static Object getBean(String name) {
    return applicationContext.getBean(name);
  }

  public static <T> T getBean(Class<T> clazz) {
    return applicationContext.getBean(clazz);
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

  @Override
  public void destroy() throws Exception {
    applicationContext = null;
  }

}
