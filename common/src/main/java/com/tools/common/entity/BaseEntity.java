package com.tools.common.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author jeff
 * @Date 2019/2/27 4:59 PM
 * @Description TODO
 * @Version 0.1
 */
@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = false)
public abstract class BaseEntity extends AuditingEntity{

  @Column(name = "created_by",length = 50)
  protected String createdBy;


  @Column(name = "last_modified_by", length = 50)
  protected String lastModifiedBy;


  @Column(name="deleted",columnDefinition = "BOOLEAN DEFAULT FALSE")
  protected boolean deleted;

  @Column(name="active", columnDefinition = "BOOLEAN DEFAULT TRUE")
  protected boolean active;

  @Column
  protected Integer status;
}
