/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.amazon.shopping.dao.CustomerDao;
import org.amazon.shopping.dao.ProductDao;
import org.amazon.shopping.dao.ROCDao;
import org.amazon.shopping.dao.UserDao;
import org.amazon.shopping.dao.VendorDao;
import org.amazon.shopping.model.Customer;
import org.amazon.shopping.model.Product;
import org.amazon.shopping.model.ROC;
import org.amazon.shopping.model.UserRoles;
import org.amazon.shopping.model.Users;
import org.amazon.shopping.model.Vendor;
import org.amazon.shopping.model.VendorLog;
import org.amazon.shopping.model.VendorLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author Sokly
 */
@SessionAttributes({ "vendor", "vendorName"})
@Controller
public class HomeController {
    
    @Autowired
    private CustomerDao customerDao;
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private ProductDao productDao;
    
    @Autowired
    private ROCDao rocdao;
    
    @Autowired
    private VendorDao vendordao;
    
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView product() {
      return new ModelAndView("product", "command", new Product());
    }
   
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("SpringWeb")Product product, 
    ModelMap model) {
      model.addAttribute("name", product.getProductName());
      model.addAttribute("desc", product.getProductDetails());
      model.addAttribute("price", product.getPrice());
      model.addAttribute("category", product.getCategory());
      model.addAttribute("brand", product.getBrand());
      model.addAttribute("quantity", product.getQuantity());
      model.addAttribute("vendor", product.getVendorName());
      model.addAttribute("image", product.getImageUrl());
      //model.addAttribute("price", product.getPrice());
      productDao.saveProduct(product);
      model.addAttribute("allProductList", productDao.getAllProducts());
      return "productUploadSuccess";
   }
    
    
    // start ROC
    
    @RequestMapping(value = "/roc", method = RequestMethod.GET)
    public ModelAndView roc() {
      return new ModelAndView("roc", "command", new ROC());
    }
   
    @RequestMapping(value = "/addROC", method = RequestMethod.POST)
    public String addROC(@ModelAttribute("SpringWeb")ROC roc, 
    ModelMap model) {
      rocdao.saveROC(roc);
      model.addAttribute("allProductList", productDao.getAllProducts());
      return "rocUploadSuccess";
   }
    
    // end
    
    // start Vendor
    
    @RequestMapping(value = "/vendor", method = RequestMethod.GET)
    public ModelAndView vendor() {
      return new ModelAndView("vendor", "command", new Vendor());
    }
   
    @RequestMapping(value = "/addVendor", method = RequestMethod.POST)
    public String addROC(@ModelAttribute("SpringWeb")Vendor vendor, 
    ModelMap model) {
        
      boolean vendorJSON = vendordao.getAuthROC(vendor.getVendor_name(), vendor.getCountry());
          
      if (!vendorJSON) {
            model.addAttribute("vendorRegStatus", "not authorized vendor");
      } else if(vendordao.doesVendorExists(vendor)) {
          model.addAttribute("vendorRegStatus", "vendor exists");
      } else if (vendorJSON) {
          //PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
          //vendor.setPassword(passwordEncoder.encode(vendor.getPassword()));
          vendordao.saveVendor(vendor);
      }
      model.addAttribute("allProductList", productDao.getAllProducts());
      return "vendorUploadSuccess";
   }
    
    // end
    
    // start Vendor
    
    @RequestMapping(value = "/vendorLogin", method = RequestMethod.GET)
    public ModelAndView vendorLogin() {
      return new ModelAndView("vendorLogin", "command", new VendorLogin());
    }
   
    @RequestMapping(value = "/loginVendor", method = RequestMethod.POST)
    public ModelAndView loginVendor(@ModelAttribute("SpringWeb")VendorLogin vlogin) {
        ModelAndView modelAndView = new ModelAndView("product", "command", new Product());
        if(vendordao.verifyLogin(vlogin)) {                      
           modelAndView.setViewName("product");
           modelAndView.addObject("vendor", vlogin);
           modelAndView.addObject("vendorName", vlogin.getVendor_name());
           VendorLog v = new VendorLog();
           v.setVendor_name(vlogin.getVendor_name());
           v.setPassword(vlogin.getPassword());
           v.setStatus("current");
           vendordao.enterVendorLog(v);
      }
      return modelAndView;
   }
    
    @RequestMapping(value = "/vendorLogout", method = RequestMethod.GET)
    public ModelAndView vendorLogout(@ModelAttribute("vendor") VendorLogin vlogin, SessionStatus status) {
      //return new ModelAndView("vendorLogout", "command", new vendorLogout());
        status.setComplete();      
        ModelAndView modelAndView = new ModelAndView("vendorLogout", "command", new VendorLogin());
        modelAndView.setViewName("vendorLogout");
        return modelAndView;
    }
    
    // end
    
    @RequestMapping("/home")
    public String hello(@RequestParam(value="str", required=false, defaultValue="") String str, 
            Model model) {
        model.addAttribute("productList", customerDao.getProductList(str));
        return "home";
    }
    
    @RequestMapping("/")
    public String home() {
        return "index";
    }
    
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null){    
        new SecurityContextLogoutHandler().logout(request, response, auth);
    }
    return "redirect:/login?logout";
}
    
    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("customer", new Customer());
        return "signup";
    }
    
    @RequestMapping(value= "signup", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("customer") Customer c){
        customerDao.saveCustomer(c);
        Users user = new Users();
        user.setUsername(c.getEmail());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	user.setPassword(passwordEncoder.encode(c.getPassword()));
        user.setEnabled(true);
 
        UserRoles role = new UserRoles();
        role.setUser(user);
        role.setRole("ROLE_USER");
        
        Set<UserRoles> roles = new HashSet<UserRoles>();
        roles.add(role);
        user.setUserRole(roles);
        userDao.saveUser(user);
        
        return "redirect:/home.htm";
        
        
    }
    
//approval
    
    @RequestMapping(value="/approval", method = RequestMethod.GET)
    public String approvalPage (@ModelAttribute("SpringWeb")Vendor vendor, ModelMap model) {
    	List<Vendor> vendors= vendordao.findAll();
    	
    	model.addAttribute("vendors", vendors);
    
    return "approval";
    
    }
    
    // product approval
    
    @RequestMapping(value = "/productApproval", method = RequestMethod.GET)
    public String productApproval(@ModelAttribute("SpringWeb")Product product, 
    ModelMap model) {
        List<Product> products= productDao.findAll();
    	
    	model.addAttribute("products", products);
    
        return "productApproval";
   }
    
    
    
    
}
