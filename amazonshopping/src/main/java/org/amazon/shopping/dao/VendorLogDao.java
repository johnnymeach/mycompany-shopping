/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.dao;

import org.amazon.shopping.model.VendorLog;

/**
 *
 * @author TonyLiu
 */
public interface VendorLogDao {
    VendorLog getCurrentVendor();
    long adjustUsedSpace(String vname, long space);
}
