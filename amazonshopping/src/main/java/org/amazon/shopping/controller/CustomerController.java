package org.amazon.shopping.controller;

import org.amazon.shopping.dao.CustomerDao;
import org.amazon.shopping.model.Customer;
import org.amazon.shopping.model.CustomerAddress;
import org.amazon.shopping.model.CustomerCard;
import org.amazon.shopping.model.TransactionItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customer/")
public class CustomerController {

	
    @Autowired
    private CustomerDao customerDao;

    
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/add";
    }
     
    @RequestMapping(value= "save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") Customer c){
        customerDao.saveCustomer(c);
        return "redirect:/home.htm";
         
    }
    
    private Customer getLoggedInCustomer() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Username="+auth.getName());
        return customerDao.getCustomerByUsername(auth.getName());
    }
    
    @RequestMapping(value = "addAddress", method = RequestMethod.GET)
    public String addAddress(@RequestParam(value="addressType") int addressType,
            @RequestParam(value="path", defaultValue="/customer/profile") String path,
            Model model) {
        CustomerAddress add = new CustomerAddress();
        Customer c = getLoggedInCustomer();
        c.setPath(path);
        add.setCustomer(c);
        add.setAddressType(addressType);
        model.addAttribute("customer", c);
        model.addAttribute("address", add);
        return "customer/addAddress";
    }
     
    @RequestMapping(value= "saveAddress", method = RequestMethod.POST)
    public String saveAddress(@ModelAttribute("address") CustomerAddress c){
        customerDao.saveAddress(c);
        return "redirect:"+c.getCustomer().getPath();
         
    }
    
    @RequestMapping(value = "addCard", method = RequestMethod.GET)
    public String addCard(@RequestParam(value="path", defaultValue="/customer/profile") String path,
            Model model) {
        CustomerCard card = new CustomerCard();
        Customer c = getLoggedInCustomer();
        c.setPath(path);
        card.setCustomer(c);
        model.addAttribute("customer", c);
        model.addAttribute("card", card);
        return "customer/addCard";
    }
     
    @RequestMapping(value= "saveCard", method = RequestMethod.POST)
    public String saveCard(@ModelAttribute("card") CustomerCard c){
        customerDao.saveCard(c);
        return "redirect:"+c.getCustomer().getPath();
         
    }
    
    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public String profile(Model model) {
        Customer c = getLoggedInCustomer();
        if(c != null && c.getCardList() != null) {
            //BytesEncryptor en = Encryptors.standard(CustomerDao.PASSWORD, CustomerDao.SALT);
            for(CustomerCard card: c.getCardList()) {
                card.setCardNo(new String(card.getCardNoByte(), CustomerDao.UTF8_CHARSET));
                System.out.println("ID:"+card.getId()+" CARD-NO:"+card.getCardNo());
            }
        }
        model.addAttribute("customer", c);
        return "customer/profile";
    }
    
    @RequestMapping(value = "addToCart", method = RequestMethod.GET, headers="Accept=application/json")
    public @ResponseBody List<TransactionItem> addToCart(Model model, HttpServletRequest  req, HttpServletResponse res,
            @RequestParam("id") int id,
            @RequestParam("name") String name) {
        System.out.println("SessionID:"+req.getSession().getId());
        List<TransactionItem> cart = (List<TransactionItem>)req.getSession().getAttribute("cart");
        if(cart == null)
            cart = new ArrayList<TransactionItem>();
        TransactionItem item = new TransactionItem();
        //p.setProductId(id);
        
        cart.add(item);
        req.getSession().setAttribute("cart", cart);
        return cart;
    }

}
