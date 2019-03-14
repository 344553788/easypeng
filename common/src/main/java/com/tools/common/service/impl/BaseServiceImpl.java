package com.tools.common.service.impl;

import com.tools.common.dao.BaseRepository;
import com.tools.common.service.BaseService;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author jeff
 * @Date 2018/12/11 12:22 PM
 * @Description TODO
 * @Version 0.1
 */
public abstract class BaseServiceImpl<T,ID extends Serializable,R extends BaseRepository<T,ID>> implements
    BaseService<T,ID,R> {
  @PersistenceContext
  protected EntityManager em;

  @Autowired
  protected ModelMapper modelMapper;

  @Autowired
  protected R baseRepository;
  @Override
  public T findOne(ID id) {
    return baseRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }
  @Override
  public R getRepository() {
    return baseRepository;
  }
  @Transactional
  @Override
  public T updateOne(ID id,T entity) {
    return updateOne(baseRepository,id,entity);
  }

  @Transactional
  @Override
  public <TT, TID extends Serializable> TT updateOne(BaseRepository<TT, TID> baseRepository, TID id, TT entity) {
    TT tdb=baseRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    modelMapper.map(entity,tdb);
    baseRepository.saveAndFlush(tdb);
    return tdb;
  }
  @Override
  public T saveOne(T entity) {
    return saveOne(baseRepository,entity);
  }
  @Override
  public <TT, TID extends Serializable> TT saveOne(BaseRepository<TT, TID> baseRepository, TT entity) {
    return baseRepository.save(entity);
  }
  @SuppressWarnings("all")
  @Override
  public void deleteById(ID id) {
    if(baseRepository.existsById(id)){
      baseRepository.deleteById(id);
    }
  }

  @Override
  public boolean exists(ID id) {
    return baseRepository.existsById(id);
  }

  @Override
  public List<T> findAll(Example<T> example) {
    return baseRepository.findAll(example);
  }
  @Override
  public List<T> findAll() {
    return baseRepository.findAll();
  }

  @Override
  public Page<T> findAll(Pageable pageable) {
    return baseRepository.findAll(pageable);
  }
  @Transactional
  @Override
  public T saveOrUpdate(ID id, T t){
    if(id!=null){
      T db=findOne(id);
      if(db!=null){
        return updateOne(id,t);
      }
    }
    return saveOne(t);
  }
  @Transactional
  @Override
  public <S extends T> Iterable<S> saveAll(Iterable<S> entities){
    return baseRepository.saveAll(entities);
  }
}
