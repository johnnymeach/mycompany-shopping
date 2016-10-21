/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.controller;


import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.amazon.shopping.model.Product;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nizomiddin
 */
@RestController
@RequestMapping("/cart/")
public class ShoppingCart {
    
    @RequestMapping(value = "add", method = RequestMethod.GET, headers="Accept=application/json")
    public @ResponseBody List<Product> addToCart(Model model, HttpServletRequest  req, HttpServletResponse res,
            @RequestParam("id") int id,
            @RequestParam("name") String name) {
        List<Product> cart = (List<Product>)req.getSession().getAttribute("cart");
        if(cart == null)
            cart = new ArrayList<Product>();
        Product p = new Product();
        p.setProductId(id);
        cart.add(p);
        return cart;
    }
}
