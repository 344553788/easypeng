package com.tools.zuul.fallback;

import com.tools.common.exception.ResultStatus;
import com.tools.common.response.GeneticResponse;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @Author jeff
 * @Date 2019/2/28 3:57 PM
 * @Description TODO
 * @Version 0.1
 */
@Component
public class FallBackHandler implements FallbackProvider {

  @Override
  public String getRoute() {
    //代表所有的路由都适配该设置
    return "*";
  }

  @Override
  public ClientHttpResponse fallbackResponse(String route, Throwable cause) {

    return new ClientHttpResponse() {
      @Override
      public HttpStatus getStatusCode(){
        return HttpStatus.OK;
      }

      @Override
      public int getRawStatusCode() {
        return 200;
      }

      @Override
      public String getStatusText() {
        return "OK";
      }

      @Override
      public void close() {

      }

      @Override
      public InputStream getBody() {
        GeneticResponse geneticResponse = new GeneticResponse(ResultStatus.http_status_internal_server_error);
        return new ByteArrayInputStream(geneticResponse.toString().getBytes());
      }

      @Override
      public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
      }
    };
  }
}
