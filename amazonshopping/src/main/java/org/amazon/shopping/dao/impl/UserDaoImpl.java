/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.amazon.shopping.dao.UserDao;
import org.amazon.shopping.model.Users;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nizomiddin
 */
@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    public void saveUser(Users u) {
//        sessionFactory.getCurrentSession()
//			.createQuery("delete from UserRoles where user.username=?")
//			.setParameter(0, u.getUsername()).executeUpdate();
        sessionFactory.getCurrentSession().persist(u);
//        for(UserRoles role: u.getUserRole()) {
//            sessionFactory.getCurrentSession().persist(role);
//        }
    }

    @Transactional
    public Users getUserByUsername(String username) {
        List<Users> users = sessionFactory.getCurrentSession()
			.createQuery("from Users where username=?")
			.setParameter(0, username)
			.list();
        if (users.size() > 0) {
            return users.get(0);
	} else {
            return null;
	}
    }

    @Transactional
    public List<Users> getUsers() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Users.class);
        return criteria.list();
    }
    
}
