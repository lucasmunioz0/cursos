package com.sga.services;

import com.sga.dal.repositories.BaseRepository;
import java.util.List;

public abstract class BaseService<T> {
    protected BaseRepository repository;

    public BaseService(BaseRepository repository) {
        this.repository = repository;
    }

    public List<T> getAll() {
        return repository.getAll();
    }

    public abstract T getById(Long id);

    public boolean insert(T assignment) {
        try {
            repository.insert(assignment);
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public boolean update(T assignment) {
        try {
            repository.update(assignment);
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public boolean delete(T assignment) {
        try {
            repository.delete(assignment);
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }
}
