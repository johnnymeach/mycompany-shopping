/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.amazon.shopping.dao.BankDao;
import org.amazon.shopping.model.BankCard;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nizomiddin
 */
@Service
public class BankDaoImpl implements BankDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public BankCard getBankCard(String cardNo, String cardCode, String cardExpiry, String fullName) {
        List<BankCard> list = sessionFactory.getCurrentSession()
			.createQuery("from BankCard where cardNo=? and cardCode=? and cardExpiry=? and fullName=?")
			.setParameter(0, cardNo)
			.setParameter(1, cardCode)
			.setParameter(2, cardExpiry)
			.setParameter(3, fullName)
			.list();
        if (list.size() > 0) {
            //System.out.println("Customer found for "+username);
            return list.get(0);
	} else {
            //System.out.println("Customer not found for "+username);
            return null;
	}
        
    }

    @Transactional
    public String updateBankCard(BankCard card) {
        sessionFactory.getCurrentSession().update(card);
        return "OK";
    }
    
}
