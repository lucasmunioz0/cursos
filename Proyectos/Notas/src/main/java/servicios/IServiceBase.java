package servicios;

import java.util.List;

public interface IServiceBase<T> {
    public List<T> findAll();
    public T getById(T t);
    public void insert(T t);
    public void update(T t);
    public void delete(T t);
}
