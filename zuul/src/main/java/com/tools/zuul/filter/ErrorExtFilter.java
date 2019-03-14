package com.tools.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

/**
 * @Author jeff
 * @Date 2019/2/28 2:51 PM
 * @Description TODO
 * @Version 0.1
 */
@Component
public class ErrorExtFilter extends SendErrorFilter {

  @Override
  public String filterType() {
    return "error";
  }

  @Override
  public int filterOrder() {
    return 30; //大于ErrorFilter的值
  }


  //只处理post过滤器抛出异常的过滤器
  @Override
  public boolean shouldFilter() {
    //判断，仅处理来自post过滤器引起的异常
    RequestContext context = RequestContext.getCurrentContext();
    ZuulFilter failedFilter =(ZuulFilter)context.get("failed.filter");
    if(failedFilter != null && failedFilter.filterType().equals("post")){
      return true;
    }

    return false;

  }
}
