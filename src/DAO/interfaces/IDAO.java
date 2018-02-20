
package DAO.interfaces;

import java.util.List;
import java.sql.SQLException;


public interface IDAO <T, ID> {

    void add(T t);

    void update(T t);

    void delete(T t);

    List<T> findAll();

    T findById(ID id);
}
