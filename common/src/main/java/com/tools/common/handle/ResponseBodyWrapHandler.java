package com.tools.common.handle;

/**
 * @Author jeff
 * @Date 2018/12/12 2:05 PM
 * @Description TODO
 * @Version 0.1
 */

import com.tools.common.exception.ResultStatus;
import com.tools.common.response.GeneticResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;


public class ResponseBodyWrapHandler implements HandlerMethodReturnValueHandler {

  private final HandlerMethodReturnValueHandler delegate;

  public ResponseBodyWrapHandler(HandlerMethodReturnValueHandler delegate) {
    this.delegate = delegate;
  }

  @Override
  public boolean supportsReturnType(MethodParameter returnType) {
    return delegate.supportsReturnType(returnType);
  }

  @Override
  public void handleReturnValue(Object returnValue,
      MethodParameter returnType,
      ModelAndViewContainer mavContainer,
      NativeWebRequest webRequest) throws Exception {
    GeneticResponse result = new GeneticResponse(ResultStatus.SUCCESS.getCode(),null,returnValue);
    delegate.handleReturnValue(result, returnType, mavContainer, webRequest);
  }
}
