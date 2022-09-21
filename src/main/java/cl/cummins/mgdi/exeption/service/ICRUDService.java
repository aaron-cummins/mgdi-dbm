package cl.cummins.mgdi.exeption.service;

import java.util.List;
import java.util.Optional;

public interface ICRUDService<T> {
    List<T> findAll();

    Optional<T> findById(Long id);

    T create(T model);

    T update(T model);

    void delete(Long id);
}
