package com.udemy.compras.service;

import java.util.List;

/**
 *
 * @param <T> Object Type
 * @param <I> ID
 */
public interface BasicCrudService<T,I>{

    public T findById(I id);
    public List<T> listAll();
    public T save(T obj);
    public void deleteById(I id);

}
