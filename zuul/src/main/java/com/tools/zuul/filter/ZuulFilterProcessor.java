package com.tools.zuul.filter;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

/**
 * @Author jeff
 * @Date 2019/2/28 2:50 PM
 * @Description TODO
 * @Version 0.1
 */
@Component
public class ZuulFilterProcessor extends FilterProcessor {

  @Override
  public Object processZuulFilter(ZuulFilter filter) throws ZuulException {
    try{
      return super.processZuulFilter(filter);
    }catch (ZuulException e){
      RequestContext requestContext = RequestContext.getCurrentContext();
      requestContext.set("failed.filter",filter);
      throw e;
    }
  }
}
