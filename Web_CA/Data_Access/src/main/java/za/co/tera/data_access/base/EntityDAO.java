package za.co.tera.Data_Access.base;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Laptop on 7/3/2014.
 */
public interface EntityDAO<T> extends Serializable {
    public void saveOrUpdate(T object);
    public void delete(T object);
    public T find(int id);
    public List<T> findAllObject();
}
