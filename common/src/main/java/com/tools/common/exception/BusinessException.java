package com.tools.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author jeff
 * @Date 2019/2/28 11:55 AM
 * @Description TODO
 * @Version 0.1
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends Exception{


  private static final long serialVersionUID = 3557000117101787675L;

  //业务类型
  private String bizType;
  //业务代码
  private int bizCode;
  //错误信息
  private String message;

  public BusinessException(String bizType, int bizCode, String message){
    super(message);
    this.bizType = bizType;
    this.bizCode = bizCode;
    this.message = message;
  }

  public BusinessException(String message){
    super(message);
    this.bizType = "";
    this.bizCode = -1;
    this.message = message;
  }

  public BusinessException(String bizType, String message){
    super(message);
    this.bizType = bizType;
    this.bizCode = -1;
    this.message = message;
  }

  public BusinessException(ResultStatus resultStatus){
    this(resultStatus.getCode(),resultStatus.getMsg());
  }

  public BusinessException(int bizCode, String message){
    super(message);
    this.bizType = "";
    this.bizCode = bizCode;
    this.message = message;
  }

}
