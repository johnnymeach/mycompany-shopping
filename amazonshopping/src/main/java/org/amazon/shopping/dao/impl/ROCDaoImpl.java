/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.amazon.shopping.dao.ROCDao;
import org.amazon.shopping.model.Product;
import org.amazon.shopping.model.ROC;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sokly
 */
@Service
public class ROCDaoImpl implements ROCDao {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    public void saveROC(ROC roc) {
        Session session = sessionFactory.getCurrentSession();

        if (session.getTransaction() != null
            && session.getTransaction().isActive()) {
        
        } else {
            session.beginTransaction();
        }
        session.save(roc);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    public List<ROC> getROCByName(String name) {
        List<ROC> rocByName = new ArrayList<ROC>();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ROC.class);
        List<ROC> roc = criteria.list();
        for(ROC r : roc) {
            if(r.getCompany_name().equals(name)) {
            	rocByName.add(r);
            }
        }
        return rocByName;
    }
    
}
