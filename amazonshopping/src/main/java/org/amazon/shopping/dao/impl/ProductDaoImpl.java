/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.amazon.shopping.dao.ProductDao;
import org.amazon.shopping.model.Product;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Tonyliu
 */
@Service
public class ProductDaoImpl implements ProductDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    public List<Product> findAll() {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("from Product").list();
        return products;
    }
    

    
    //status has three attributes: '0' means need to approve, '1' means approved, '2' means disapprove
    @Transactional
    public String changeProductStatus(int id) {
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("update product set status=? where productId=" + id);
        query.setParameter(0, '1');
        int result = query.executeUpdate();
        if(result == 1) {
            return "Product has been approved!";
        } else {
            return "Some problem occured!";
        }
    }
    
    @Transactional
    public String disapprovalStatus(int id) {
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("update product set status=? where productId=" + id);
        query.setParameter(0, '2');
        int result = query.executeUpdate();
        if(result == 1) {
            return "Product has been disaproved!";
        } else {
            return "Some problem is occured!";
        }
    }
    
    @Transactional
    public Product getProductById(int id) {
        return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Transactional
    public List<Product> getAllProducts() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
        return criteria.list();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Transactional
    public List<Product> getProductsByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<Product>();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
        List<Product> products = criteria.list();
        for(Product product : products) {
            if(product.getCategory().equals(category)) {
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Transactional
    public List<Product> getProductsByBrand(String brand) {
        List<Product> productsByBrand = new ArrayList<Product>();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
        List<Product> products = criteria.list();
        for(Product product : products) {
            if(product.getBrand().equals(brand)) {
                productsByBrand.add(product);
            }
        }
        return productsByBrand;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Transactional
    public void saveProduct(Product product) {
        
        Session session = sessionFactory.getCurrentSession();

        if (session.getTransaction() != null
            && session.getTransaction().isActive()) {
        
        } else {
            session.beginTransaction();
        }
        session.save(product);
    }
    
}
