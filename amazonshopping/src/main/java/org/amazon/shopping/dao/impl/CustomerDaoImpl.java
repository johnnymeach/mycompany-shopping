/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.amazon.shopping.dao.CustomerDao;
import org.amazon.shopping.model.Customer;
import org.amazon.shopping.model.CustomerAddress;
import org.amazon.shopping.model.CustomerCard;
import org.amazon.shopping.model.Product;
import org.amazon.shopping.model.TransactionItem;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nizomiddin
 */
@Service
public class CustomerDaoImpl implements CustomerDao {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    public void saveCustomer(Customer c) {
        sessionFactory.getCurrentSession().save(c);
    }

    @Transactional
    public Customer getCustomerById(int customerId) {
        return (Customer) sessionFactory.getCurrentSession().get(Customer.class, customerId);
    }

    @Transactional
    public List<Customer> getCustomers() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
        return criteria.list();
    }

	public void removeCustomer(int id) {
		// TODO Auto-generated method stub
		
	}

    @Transactional
    public void saveTranItem(TransactionItem item) {
        sessionFactory.getCurrentSession().save(item);
    }

    @Transactional
    public List<TransactionItem> getTransactionItems(int customerId) {
        List<TransactionItem> items = sessionFactory.getCurrentSession()
			.createQuery("from TransactionItem where customer.id=? and transaction is null")
			.setParameter(0, customerId)
			.list();
        System.out.println("cart-size: "+items.size());
        return items;
    }

    @Transactional
    public void removeTransactionItem(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Transactional
    public Customer getCustomerByUsername(String username) {
        List<Customer> list = sessionFactory.getCurrentSession()
			.createQuery("from Customer where email=?")
			.setParameter(0, username)
			.list();
        if (list.size() > 0) {
            //String email = list.get(0).getCardNo() == null ? "null" : new String(list.get(0).getCardNo(), UTF8_CHARSET);
            System.out.println("Customer found for "+username);
            return list.get(0);
	} else {
            System.out.println("Customer not found for "+username);
            return null;
	}
    }

    @Transactional
    public void saveAddress(CustomerAddress add) {
        sessionFactory.getCurrentSession()
			.createQuery("update CustomerAddress set enabled=false where customer.id=? and addressType=?")
			.setParameter(0, add.getCustomer().getId()).setParameter(1, add.getAddressType()).executeUpdate();
        add.setEnabled(true);
        sessionFactory.getCurrentSession().persist(add);
    }
    
    @Transactional
    public List<CustomerAddress> getCustomerAddresses(int cId) {
        List<CustomerAddress> items = sessionFactory.getCurrentSession()
			.createQuery("from CustomerAddress where customer.id=?")
			.setParameter(0, cId)
			.list();
        return items;
    }

    
    
    @Transactional
    public void saveCard(CustomerCard card) {
        System.out.println("CARD-NO:"+card.getCardNo());
        sessionFactory.getCurrentSession()
			.createQuery("update CustomerCard set enabled=false where customer.id=?")
			.setParameter(0, card.getCustomer().getId()).executeUpdate();
        card.setEnabled(true);
        
        //BytesEncryptor en = Encryptors.standard(PASSWORD, SALT);
        if(card.getCardNo() != null && card.getCardNo().trim().length() > 0)
            card.setCardNoByte(card.getCardNo().getBytes(UTF8_CHARSET));
        if(card.getCardCode() != null && card.getCardCode().trim().length() > 0)
            card.setCardCodeByte(card.getCardCode().getBytes(UTF8_CHARSET));
        if(card.getCardExpiry() != null && card.getCardExpiry().trim().length() > 0)
            card.setCardExpiryByte(card.getCardExpiry().getBytes(UTF8_CHARSET));
        sessionFactory.getCurrentSession().persist(card);
    }

    @Transactional
    public List<CustomerCard> getCustomerCards(int cId) {
        List<CustomerCard> items = sessionFactory.getCurrentSession()
			.createQuery("from CustomerCard where customer.id=? order by id desc")
			.setParameter(0, cId)
			.list();
        if(items != null) {
            for(CustomerCard card: items) {
                card.setCardNo(new String(card.getCardNoByte(), UTF8_CHARSET));
                System.out.println("ID:"+card.getId()+" CARD-NO:"+card.getCardNo());
            }
        }
        return items;
    }
    
    @Transactional
    public List<Product> getProductList(String str) {
        List<Product> items = sessionFactory.getCurrentSession()
			.createQuery("from Product where productName like ? or vendorName like ?")
			.setParameter(0, "%"+str+"%")
                        .setParameter(1, "%"+str+"%")
                        .list();
        return items;
    }
  
  
}
