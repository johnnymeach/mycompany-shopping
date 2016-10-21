/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.dao;

import org.amazon.shopping.model.Product;

/**
 *
 * @author Sokly
 */
public interface ProductUploadDao {
    public int uploadProduct(Product product);
}
