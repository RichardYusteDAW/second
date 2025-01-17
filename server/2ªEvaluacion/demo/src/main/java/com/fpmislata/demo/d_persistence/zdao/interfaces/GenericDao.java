package com.fpmislata.demo.d_persistence.zdao.interfaces;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {

    List<T> findAll();

    Optional<T> findById(Integer id);

    void save(T t);

    void delete(Integer id);
}