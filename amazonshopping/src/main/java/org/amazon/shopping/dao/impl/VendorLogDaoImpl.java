/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.dao.impl;

import java.util.List;

import org.amazon.shopping.dao.VendorLogDao;
import org.amazon.shopping.model.Vendor;
import org.amazon.shopping.model.VendorLog;
import org.amazon.shopping.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author TonyLiu
 */
public class VendorLogDaoImpl implements VendorLogDao {
    
    private Session session;

    public VendorLog getCurrentVendor() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VendorLog.class);
        List<VendorLog> logs = criteria.list();
        for (VendorLog log : logs) {
            if("current".equals(log.getStatus())) {
                return log;
            }
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public long adjustUsedSpace(String vname, long space) {        
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Vendor.class);
        long usedSpace = 0;
        List<Vendor> vList = criteria.list();
        for (Vendor v : vList) {
            if (v.getVendor_name().equalsIgnoreCase(vname)) {
               v.setUsed_space(v.getUsed_space()+space);
               usedSpace = v.getUsed_space();
               if (v.getUsed_space() <= 50000) {
               session.update(v);
               session.getTransaction().commit(); }
            }
        }        
        session.close();
        return usedSpace;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
