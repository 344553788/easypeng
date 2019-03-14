package com.tools.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.tools.common.response.GeneticResponse;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author jeff
 * @Date 2019/2/28 1:36 PM
 * @Description TODO
 * @Version 0.1
 */
@Slf4j
@Component
public class ErrorFilter extends ZuulFilter {

  private static final String ERROR_STATUS_CODE_KEY = "error.status_code";

  public static final String DEFAULT_ERR_MSG = "系统繁忙,请稍后再试";

  @Override
  public String filterType() {
    return "post";
  }

  @Override
  public int filterOrder() {
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    RequestContext ctx = RequestContext.getCurrentContext();
    return ctx.containsKey(ERROR_STATUS_CODE_KEY);
  }

  @Override
  public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();
    try {
      HttpServletRequest request = ctx.getRequest();
      int statusCode = (Integer) ctx.get(ERROR_STATUS_CODE_KEY);
      String message = (String) ctx.get("error.message");
      if (ctx.containsKey("error.exception")) {
        Throwable e = (Exception) ctx.get("error.exception");
        Throwable re = getOriginException(e);
        if (re instanceof java.net.ConnectException) {
          message = "Real Service Connection refused";
          log.warn("uri:{},error:{}", request.getRequestURI(), re.getMessage());
        } else if (re instanceof java.net.SocketTimeoutException) {
          message = "Real Service Timeout";
          log.warn("uri:{},error:{}", request.getRequestURI(), re.getMessage());
        } else if (re instanceof com.netflix.client.ClientException) {
          message = re.getMessage();
          log.warn("uri:{},error:{}", request.getRequestURI(), re.getMessage());
        } else {
          log.warn("Error during filtering", e);
        }
      }
      if (StringUtils.isBlank(message)) {
        message = DEFAULT_ERR_MSG;
      }
      return new GeneticResponse(statusCode,message);
    } catch (Exception e) {
      String error = "Error during filtering[ErrorFilter]";
      log.error(error, e);
      return new GeneticResponse(500,error);
    }
  }

  private Throwable getOriginException(Throwable e) {
    e = e.getCause();
    while (e.getCause() != null) {
      e = e.getCause();
    }
    return e;
  }
}
