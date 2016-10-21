/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.amazon.shopping.dao.CartDao;
import org.amazon.shopping.model.Product;
import org.amazon.shopping.model.Transaction;
import org.amazon.shopping.model.TransactionItem;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nizomiddin
 */
@Service
public class CartDaoImpl implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    public void saveItem(TransactionItem item) {
        sessionFactory.getCurrentSession().save(item);
    }

    @Transactional
    public String saveTransaction(Transaction tr, List<TransactionItem> items) {
        for(TransactionItem item: items) {
            if(item.getProduct().getQuantity() < item.getItemQty())
                return "Out of stock";
        }    
        sessionFactory.getCurrentSession().save(tr);        
        for(TransactionItem item: items) {
            item = (TransactionItem)sessionFactory.getCurrentSession().get(TransactionItem.class, item.getId());
            item.setTransaction(tr);
            sessionFactory.getCurrentSession().save(item);
            Product p = (Product)sessionFactory.getCurrentSession().get(Product.class, item.getProduct().getProductId());
            int quantity = p.getQuantity();
            p.setQuantity(quantity - item.getItemQty());
            sessionFactory.getCurrentSession().save(p);       
        }
        return "OK";
    }
    
    @Transactional
    public Product getProductById(int pId) {
        return (Product) sessionFactory.getCurrentSession().get(Product.class, pId);
    }

    @Transactional
    public List<TransactionItem> getCartItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    public void removeItem(int id) {
        sessionFactory.getCurrentSession()
			.createQuery("delete from TransactionItem where id=?")
			.setParameter(0, id).executeUpdate();

    }
    
}
