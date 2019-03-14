package com.tools.common.dao;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @Author jeff
 * @Date 2018/11/22 12:26 PM
 * @Description Dao的基础类，所有的Dao方法集成该类
 * @Version 0.1
 */
@NoRepositoryBean
public interface BaseRepository<T,ID extends Serializable> extends CrudRepository<T,ID> ,JpaRepository<T,ID>,JpaSpecificationExecutor<T> {
}
