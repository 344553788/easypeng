package com.tools.common.entity;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@TypeDef(name = "string-array",typeClass = StringArrayType.class)
public abstract class AuditingEntity implements Serializable {

    private static final long serialVersionUID = -5153428345271482597L;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    protected Date createTime;

//    @LastModifiedBy
//    @Column(name = "last_modified_by", length = 50)
//    protected String lastModifiedBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at" , nullable = false)
    protected Date updateTime;



}
