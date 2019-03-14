package com.tools.common.handle;

/**
 * @Author jeff
 * @Date 2018/12/12 2:09 PM
 * @Description 初始化切面
 * @Version 0.1
 */

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

public class ResponseBodyWrapFactoryBean implements InitializingBean {

  @Autowired
  private RequestMappingHandlerAdapter adapter;

  @Override
  public void afterPropertiesSet() throws Exception {
    List<HandlerMethodReturnValueHandler> returnValueHandlers = adapter.getReturnValueHandlers();
    List<HandlerMethodReturnValueHandler> handlers = new ArrayList(returnValueHandlers);
    decorateHandlers(handlers);
    adapter.setReturnValueHandlers(handlers);
  }


  private void decorateHandlers(List<HandlerMethodReturnValueHandler> handlers) {
    for (HandlerMethodReturnValueHandler handler : handlers) {
      if (handler instanceof RequestResponseBodyMethodProcessor) {
        ResponseBodyWrapHandler decorator = new ResponseBodyWrapHandler(handler);
        int index = handlers.indexOf(handler);
        handlers.set(index, decorator);
        break;
      }
    }
  }

}