/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.controller;

import java.util.List;

import org.amazon.shopping.dao.ProductDao;
import org.amazon.shopping.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author tonyliu
 */
@Controller
@RequestMapping("/product/")
public class ProductApprovalController {
    
    @Autowired
    private ProductDao productDao;
    
//    @RequestMapping("/productApproval")
//    public String productApproval(ModelMap map) {
//        List<Product> products = productDao.findAll();
//        List<ProductStatus> status = productDao.findStatus();
//        map.addAttribute("products", products);
//        map.addAttribute("status", status);
//        return "productApproval";
//    }
    
    @RequestMapping(value="/productStatusChange/{productId}", method=RequestMethod.PUT)
    @ResponseBody
    public String changeProductStatus(@PathVariable("productId") int productId) {
        String result = productDao.changeProductStatus(productId);
        return result;
    }
    
    @RequestMapping(value="/productDisapproval/{productId}", method=RequestMethod.PUT)
    @ResponseBody
    public String disapprovalStatus(@PathVariable("productId") int productId) {
        String result = productDao.disapprovalStatus(productId);
        return result;
    }
}
