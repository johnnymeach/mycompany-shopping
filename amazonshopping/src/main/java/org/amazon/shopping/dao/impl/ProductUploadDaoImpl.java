/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.dao.impl;
import org.amazon.shopping.dao.ProductUploadDao;
import org.amazon.shopping.model.Product;
import org.amazon.shopping.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Sokly
 */
public class ProductUploadDaoImpl implements ProductUploadDao {
    
    private Session session;
    
    public int uploadProduct(Product product) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        session.close();
        return 0;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
