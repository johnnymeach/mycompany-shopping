/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.controller;

import java.util.Date;
import java.util.List;

import org.amazon.shopping.dao.BankDao;
import org.amazon.shopping.dao.CartDao;
import org.amazon.shopping.dao.CustomerDao;
import org.amazon.shopping.model.BankCard;
import org.amazon.shopping.model.Customer;
import org.amazon.shopping.model.CustomerAddress;
import org.amazon.shopping.model.CustomerCard;
import org.amazon.shopping.model.Product;
import org.amazon.shopping.model.Transaction;
import org.amazon.shopping.model.TransactionItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Nizomiddin
 */
@Controller
@RequestMapping("/cart/")
public class CartController {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CartDao cartDao;

    @Autowired
    private BankDao bankDao;

    
    private Customer getLoggedInCustomer() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Username="+auth.getName());
        return customerDao.getCustomerByUsername(auth.getName());
    }
    
    private CustomerCard getActiveCard(Customer c) {
        if(c == null || c.getCardList() == null)
            return null;
        for(CustomerCard card : c.getCardList())
            if(card.isEnabled())
                return card;
        return null;
    }

    private CustomerAddress getActiveBillAddress(Customer c) {
        if(c == null || c.getAddressList() == null)
            return null;
        for(CustomerAddress add : c.getAddressList())
            if(add.isEnabled() && add.getAddressType() == 1)
                return add;
        return null;
    }
    
    
    private CustomerAddress getActiveShipAddress(Customer c) {
        if(c == null || c.getAddressList() == null)
            return null;
        for(CustomerAddress add : c.getAddressList())
            if(add.isEnabled() && add.getAddressType() == 0)
                return add;
        return null;
    }
    
    
    @RequestMapping(value = "submitOrder", method = RequestMethod.GET)
    public @ResponseBody String submitOrder(@RequestParam(value="ship") int shippingCost,
            Model model) {
        Customer c = getLoggedInCustomer();
        Transaction tr = new Transaction();
        tr.setCustomer(c);
        double totalCost = 0.0d;
        List<TransactionItem> items = customerDao.getTransactionItems(c.getId());
        for(TransactionItem item: items) {
            totalCost += item.getAmount();
        }
        tr.setAmount(totalCost+shippingCost);
        
        CustomerCard card = getActiveCard(c);
        if(card == null)
            return "Please select Credit Card information";
        tr.setCardNo(card.getCardNo());
        tr.setFullName(card.getFullName());
        
        BankCard bankCard = bankDao.getBankCard(new String(card.getCardNoByte(), CustomerDao.UTF8_CHARSET), 
                new String(card.getCardCodeByte(), CustomerDao.UTF8_CHARSET), 
                new String(card.getCardExpiryByte(), CustomerDao.UTF8_CHARSET), 
                card.getFullName());
        if(bankCard == null)
            return "Unknown Credit Card";
        if(bankCard.getBalance() < totalCost)
            return "Insuficient balance";
        tr.setCreateTime(new Date());
        double balance = bankCard.getBalance();
        bankCard.setBalance(balance - totalCost);
        String bankRes = bankDao.updateBankCard(bankCard);
        if(!"OK".equals(bankRes))
            return bankRes;
        String res = cartDao.saveTransaction(tr, items);
        return "OK".equals(res) ? "OK" : res;
    }
    
    @RequestMapping(value = "addItem", method = RequestMethod.GET)
    public @ResponseBody String addItem(@RequestParam(value="productId") int pId,
            @RequestParam(value="qty", defaultValue="1") int qty,
            Model model) {

        TransactionItem item = new TransactionItem();
        Customer c = getLoggedInCustomer();
        Product p = cartDao.getProductById(pId);
        p.setProductId(pId);
        item.setCustomer(c);
        item.setProduct(p);
        item.setItemQty(qty);
        item.setItemName(p.getProductName());
        item.setAmount(p.getPrice()*qty);
        cartDao.saveItem(item);
        return "OK";
        //return customerDao.getTransactionItems(c.getId());
    }

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String cartDetail(Model model) {
        Customer c = getLoggedInCustomer();
        model.addAttribute("cartItems", customerDao.getTransactionItems(c.getId()));
        return "cart/detail";
    }
    
    @RequestMapping(value = "removeItem", method = RequestMethod.GET)
    public String removeItem(@RequestParam(value="itemId") int itemId, Model model) {
        cartDao.removeItem(itemId);
        return "redirect:/cart/detail";
    }
    
    @RequestMapping(value = "placeOrder", method = RequestMethod.GET)
    public String placeOrder(Model model) {
        Customer c = getLoggedInCustomer();
        /*if(c != null && c.getCardList() != null) {
            for(CustomerCard card: c.getCardList()) {
                card.setCardNo(new String(card.getCardNoByte(), customerDao.UTF8_CHARSET));
            }
        }*/
        
        List<TransactionItem> items = customerDao.getTransactionItems(c.getId());
        model.addAttribute("customer", c);
        model.addAttribute("cartItems", items);
        model.addAttribute("transaction", new Transaction());   
        return "cart/placeOrder";
    }
}
