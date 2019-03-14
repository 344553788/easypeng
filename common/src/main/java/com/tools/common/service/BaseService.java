package com.tools.common.service;

import com.tools.common.dao.BaseRepository;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author jeff
 * @Date 2018/12/11 11:37 AM
 * @Description TODO
 * @Version 0.1
 */
public interface BaseService<T,ID extends Serializable,R extends BaseRepository<T,ID>> {
  R getRepository();
  T updateOne(ID id, T entity);
  <TT,TID extends Serializable> TT updateOne(BaseRepository<TT, TID> baseRepository, TID id,
      TT entity);
  T saveOne(T entity);
  <TT,TID extends Serializable> TT saveOne(BaseRepository<TT, TID> baseRepository, TT entity);
  T findOne(ID id);
  void deleteById(ID id);
  boolean exists(ID id);
  List<T> findAll();
  List<T> findAll(Example<T> example);
  Page<T> findAll(Pageable pageable);
//  Page<T> findAll(Specification<T> specification,Pageable pageable);
  T saveOrUpdate(ID id, T t);
  <S extends T> Iterable<S> saveAll(Iterable<S> entities);

}
