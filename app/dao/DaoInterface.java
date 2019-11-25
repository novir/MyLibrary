package dao;

import java.util.List;
import java.util.Optional;

public interface DaoInterface<T> {

    Optional<T> find(long id);

    List<T> findAll();

    void save(T t);

    void delete(T t);

}
