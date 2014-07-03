package za.co.tera.data_access.base;

import java.util.List;

/**
 * Created by Laptop on 7/3/2014.
 */
public interface EntityDOA<T> {
    public void saveOrUpdate(T object);
    public void delete(T object);
    public T find(int id);
    public List<T> findAllObject();
}
