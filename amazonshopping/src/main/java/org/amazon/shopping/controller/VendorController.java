/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.controller;

import org.amazon.shopping.dao.VendorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ChengMa
 */
@Controller
@RequestMapping("/vendor/")
public class VendorController {

    @Autowired
    private VendorDao vendorDao;
    
    @RequestMapping("vendorRegister")
    public String vendorRegister() {
        return "vendorRegister";
    }
    
    @RequestMapping("product")
    public String product() {
        return "product";
    }
    
    @RequestMapping("approvalPage")
    public String waitApproval() {
        return "waitApproval";
    }
    
    
    @RequestMapping(value="/approve/{vendorId}", method=RequestMethod.PUT)
    public @ResponseBody String approve(@PathVariable("vendorId") int vendorId) {
        System.out.print("click approve£¡");
    	
    	String result = vendorDao.changeStatus(vendorId);
        
        return result;
    }
    
}