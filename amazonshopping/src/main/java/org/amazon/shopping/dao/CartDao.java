/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.dao;

import java.util.List;

import org.amazon.shopping.model.Product;
import org.amazon.shopping.model.Transaction;
import org.amazon.shopping.model.TransactionItem;

/**
 *
 * @author Nizomiddin
 */
public interface CartDao {
    String saveTransaction(Transaction tr, List<TransactionItem> items);
    void saveItem(TransactionItem item);
    Product getProductById(int pId);
    List<TransactionItem> getCartItems();
    void removeItem(int id);
}
