package com.tools.common.controller;

import com.tools.common.exception.ResultStatus;
import com.tools.common.response.GeneticResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author jeff
 * @Date 2019/3/1 3:40 PM
 * @Description TODO
 * @Version 0.1
 */
@Slf4j
public class BaseController{

  @Autowired
  protected ModelMapper modelMapper;


  @GetMapping(name = "/info")
  public GeneticResponse health(){
    return new GeneticResponse(ResultStatus.SUCCESS);
  }

}

