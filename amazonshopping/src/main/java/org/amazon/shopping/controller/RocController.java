/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.controller;

import org.amazon.shopping.dao.ROCDao;
import org.amazon.shopping.model.ROC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sokly
 */
public class RocController {
    
    @Autowired
    private ROCDao rocdao;
    
    @RequestMapping(value = "/roc", method = RequestMethod.GET)
    public ModelAndView roc() {
      return new ModelAndView("roc", "command", new ROC());
    }
   
    @RequestMapping(value = "/addROC", method = RequestMethod.POST)
    public String addROC(@ModelAttribute("SpringWeb")ROC roc, 
    ModelMap model) {
      rocdao.saveROC(roc);
      //model.addAttribute("allProductList", productDao.getAllProducts());
      return "rocUploadSuccess";
    }
}
