/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.dao;

import java.util.List;

import org.amazon.shopping.model.Users;

/**
 *
 * @author Nizomiddin
 */
public interface UserDao {
  void saveUser(Users u);
  Users getUserByUsername(String username);
  List<Users> getUsers();
}
