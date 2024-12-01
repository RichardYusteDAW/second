package fpmislata.examen.d_persistence.zdao.interfaces;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {

    List<T> getAll(Integer page, Integer size);

    Optional<T> findById(Integer id);

    void delete(Integer id);

    Optional<Integer> save(T t);

    Integer count();
}