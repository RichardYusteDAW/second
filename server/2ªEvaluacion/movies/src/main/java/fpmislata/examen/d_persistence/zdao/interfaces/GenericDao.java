package fpmislata.examen.d_persistence.zdao.interfaces;

import java.util.Optional;

import fpmislata.examen.c_domain._2service.model.ListWithCount;

public interface GenericDao<T> {

    ListWithCount<T> findAll(Integer page, Integer size);

    Optional<T> findById(Integer id);

    T save(T t);

    void delete(Integer id);
}