package fpmislata.bookstore.d_persistence.zdao.interfaces;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {

    List<T> getAll(Integer page, Integer size);

    Optional<T> findById(Long id);

    void delete(Long id);

    Optional<Long> save(T t);
}