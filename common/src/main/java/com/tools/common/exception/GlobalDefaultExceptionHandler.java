package com.tools.common.exception;

import com.tools.common.response.GeneticResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jeff
 * @Date 2018/12/11 12:55 PM
 * @Description TODO
 * @Version 0.1
 */
@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class GlobalDefaultExceptionHandler {

  @ResponseBody
  @ExceptionHandler(value = Exception.class)
  public GeneticResponse exceptionHandler(Exception e) {
    log.info("",e);
    GeneticResponse geneticResponse = new GeneticResponse();
    geneticResponse.setMessage(e.getMessage());
    if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
      geneticResponse.setCode(ResultStatus.http_status_not_found.getCode());
    } else {
      geneticResponse.setCode(ResultStatus.http_status_internal_server_error.getCode());
    }
    geneticResponse.setData("");
    return geneticResponse;
  }



  @ResponseBody
  @ExceptionHandler(value = BusinessException.class)
  public GeneticResponse formatCheckExceptionHandler(BusinessException e) {
    return new GeneticResponse(e.getBizCode(), e.getMessage());
  }

  @ResponseBody
  @ExceptionHandler(value = SystemException.class)
  public GeneticResponse resourceNotFoundExceptionHandler(SystemException e) {
    return new GeneticResponse(e.getCode(), e.getMsg());
  }

}
