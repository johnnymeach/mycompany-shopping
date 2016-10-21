/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.dao;

import java.nio.charset.Charset;
import java.util.List;

import org.amazon.shopping.model.Customer;
import org.amazon.shopping.model.CustomerAddress;
import org.amazon.shopping.model.CustomerCard;
import org.amazon.shopping.model.Product;
import org.amazon.shopping.model.TransactionItem;
import org.springframework.security.crypto.keygen.KeyGenerators;

/**
 *
 * @author Nizomiddin
 */
public interface CustomerDao {
    final Charset UTF8_CHARSET = Charset.forName("UTF-8");
    final String PASSWORD = "mum-online-shop";
    final String SALT = KeyGenerators.string().generateKey();

  void saveCustomer(Customer c);
  Customer getCustomerById(int customerId);
  Customer getCustomerByUsername(String username);
  List<Customer> getCustomers();
  void removeCustomer(int id);
  void saveTranItem(TransactionItem item);
  List<TransactionItem> getTransactionItems(int customerId);
  void removeTransactionItem(int id);
  
  void saveAddress(CustomerAddress add);
  List<CustomerAddress> getCustomerAddresses(int cId);
  void saveCard(CustomerCard card);
  List<CustomerCard> getCustomerCards(int cId);
  List<Product> getProductList(String str);
  
  
}
