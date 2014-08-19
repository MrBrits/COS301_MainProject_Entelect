package za.co.tera.web_ca.data_access.base;

import java.util.List;

/**
 * Created by Laptop on 7/14/2014.
 */
public interface AbstractDao<T> {
    public T findById(int id);
    public List<T> findAll();
    public T save(T object);

    public void delete(T object);
    public long count();
}
