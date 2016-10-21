/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.dao;

import java.util.List;

import org.amazon.shopping.model.Product;

/**
 *
 * @author tonyliu
 */
public interface ProductDao {
    List<Product> findAll();
    String changeProductStatus(int id);
    String disapprovalStatus(int id);
    Product getProductById(int id);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    void saveProduct(Product product);
}
