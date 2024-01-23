package app.dao;

import java.util.Collection;

public interface AbstractDao<T> {

    T get(int id);

    Collection<T> findAll();

    void insert(T entity);

    void delete(T entity);

    void update(T entity);

}
