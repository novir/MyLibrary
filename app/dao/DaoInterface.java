package dao;

import java.util.Collection;
import java.util.Optional;

public interface DaoInterface<T> {

    Optional<T> find(long id);

    Collection<T> findAll();

    T save(T t);

    T delete(T t);

}
