package cl.cummins.mgdi.service;

import cl.cummins.mgdi.model.Cargo;

import java.util.List;
import java.util.Optional;

public interface ICRUDSevice<T> {
    List<T> findAll();

    Optional<T> findById(Long id);

    T create(T model);

    T update(T model);

    void delete(Long id);
}
