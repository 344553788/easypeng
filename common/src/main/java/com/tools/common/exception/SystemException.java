package com.tools.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author jeff
 * @Date 2018/12/11 12:25 PM
 * @Description TODO
 * @Version 0.1
 */
@Data
@Slf4j
@EqualsAndHashCode(callSuper = false)
public class SystemException extends RuntimeException{

  private Integer code;
  private String msg;

  public SystemException(int code,String msg) {
    super(msg);
    this.code = code;
    this.msg = msg;
    log.info("SystemException,code {}, message{}",code,msg);
  }

  public SystemException(ResultStatus resultStatus) {
    this(resultStatus.getCode(),resultStatus.getMsg());
    log.info("SystemException,ResultStatus {}",resultStatus);
  }

  public SystemException() {

  }
}
