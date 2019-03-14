package com.tools.common.request;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;
import lombok.Data;

/**
 * @Author jeff
 * @Date 2018/11/23 4:31 PM
 * @Description TODO
 * @Version 0.1
 */
@Data
@MappedSuperclass
public class BaseQuery implements Serializable {

  private Integer page=1;

  private Integer size=10;
}
