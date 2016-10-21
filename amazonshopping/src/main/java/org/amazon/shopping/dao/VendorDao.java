/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.dao;

import java.util.List;

import org.amazon.shopping.model.Vendor;
import org.amazon.shopping.model.VendorLog;
import org.amazon.shopping.model.VendorLogin;

/**
 *
 * @author TonyLiu
 */
public interface VendorDao {
    List<Vendor> findAll();
    String changeStatus(int id);
    void saveVendor(Vendor vendor);
    boolean verifyVendor(Vendor vendor);
    boolean doesVendorExists(Vendor vendor);
    boolean verifyLogin(VendorLogin login);
    void enterVendorLog(VendorLog log);
    boolean getAuthROC(String cname, String country);
    boolean isNullOrBlank(final String s);
}
