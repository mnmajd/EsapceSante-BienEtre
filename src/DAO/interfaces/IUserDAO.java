/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.interfaces;

import entites.User;
import java.util.List;



public interface IUserDAO extends IDAO<User, Integer> {

    User login(String username, String password);

    void changeStatus(User user, String newStatus);


    boolean checkUsername(String username);

    boolean checkUsername(String username, Integer id);

    User findByUsername(String username);
}