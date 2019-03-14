package com.tools.common.response;

import com.tools.common.exception.ResultStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @Author jeff
 * @Date 2018/12/12 1:27 PM
 * @Description TODO
 * @Version 0.1
 */
@Setter
@Getter
@NoArgsConstructor
public  class GeneticResponse<T> {

  private int code = HttpStatus.OK.value();

  private String message;
  private T data;
  private Long currentTime;

  public GeneticResponse(int code,String message,T data,Long currentTime){
    this.code = code;
    this.message  = message;
    this.data = data;
    this.currentTime = currentTime;
  }

  public GeneticResponse(int code,String message,T data){
    this.code = code;
    this.message  = message;
    this.data = data;
    this.currentTime = System.currentTimeMillis();

  }

  public GeneticResponse(ResultStatus resultStatus){
    this(resultStatus.getCode(),resultStatus.getMsg(),null);
  }

  public GeneticResponse(ResultStatus resultStatus, T data){
    this(resultStatus.getCode(),resultStatus.getMsg(),data);
  }

  public GeneticResponse(int code,String message){
    this(code,message,null);
  }


}
