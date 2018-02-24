/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.util.List;
import java.sql.SQLException;


public interface IDAO <T, ID> {

    void add(T t);

    void update(T t);

    void delete(T t);

    List<T> findAll();

    T findById(ID id);
}
