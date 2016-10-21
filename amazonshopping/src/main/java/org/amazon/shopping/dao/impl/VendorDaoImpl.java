/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.dao.impl;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.amazon.shopping.dao.ROCDao;
import org.amazon.shopping.dao.VendorDao;
import org.amazon.shopping.model.ROC;
import org.amazon.shopping.model.Vendor;
import org.amazon.shopping.model.VendorLog;
import org.amazon.shopping.model.VendorLogin;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Tonyliu
 */
@Service
public class VendorDaoImpl implements VendorDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired
    private ROCDao rocdao;
    
    @Transactional
    public List<Vendor> findAll() {
        List<Vendor> vendors = sessionFactory.getCurrentSession().createQuery("from Vendor").list();
        return vendors;
    }
    
    @Transactional
    public String changeStatus(int id) {
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("UPDATE Vendor set status=? where vendorId=" + id);
        query.setParameter(0, true);
        int result = query.executeUpdate();
        if(result == 1) {
            return "Vendor status: Activated!";
        } else {
            return "Some problem occured!";
        }
    }
       
    @Transactional
    public void saveVendor(Vendor vendor) {
        Session session = sessionFactory.getCurrentSession();

        if (session.getTransaction() != null
            && session.getTransaction().isActive()) {
        
        } else {
            session.beginTransaction();
        }
        session.save(vendor);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    public boolean verifyVendor(Vendor vendor) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ROC.class);
        List<ROC> rocList = criteria.list();
        for (ROC roc : rocList) {
            if(roc.getCompany_name().equalsIgnoreCase(vendor.getVendor_name()) && roc.getReg_num().equals(vendor.getReg_num()) && roc.getCountry().equalsIgnoreCase("USA")) {
                return true;
            }
        }
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Transactional
    public boolean doesVendorExists(Vendor vendor) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Vendor.class);
        List<Vendor> vendorList = criteria.list();
        for (Vendor v : vendorList) {
            if(v.getVendor_name().equalsIgnoreCase(vendor.getVendor_name()) && v.getCountry().equalsIgnoreCase(vendor.getCountry())) {
                return true;
            }
        }
        return false;
    }
    
    @Transactional
    public boolean verifyLogin(VendorLogin vLogin) {
        
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Vendor.class);
        List<Vendor> vendorList = criteria.list();
        for (Vendor v : vendorList) {
            if (v.getVendor_name().equalsIgnoreCase(vLogin.getVendor_name()) && v.getPassword().equals(vLogin.getPassword()) && v.isStatus()) {
                return true;
            }
        }
        return false;
    }

    @Transactional
    public void enterVendorLog(VendorLog log) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(VendorLog.class);
        Session session = sessionFactory.getCurrentSession();
        if (session.getTransaction() != null
            && session.getTransaction().isActive()) {
        
        } else {
            session.beginTransaction();
        }
        List<VendorLog> vLogs = criteria.list();
        for (VendorLog vLog : vLogs) {
            vLog.setStatus("expired");        
            session.saveOrUpdate(vLog);
        }
        session.save(log);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean getAuthROC(String cname, String country) {
      
    	ROC roc= new ROC();
    	List<ROC> rocList = rocdao.getROCByName(cname);
    	if(rocList.isEmpty()) return false;
    	return true;
    }
    
    public boolean isNullOrBlank(final String s)
    {
        return s == null || s.trim().length() == 0;
    }

}
