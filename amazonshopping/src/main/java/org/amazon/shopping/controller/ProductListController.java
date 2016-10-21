package org.amazon.shopping.controller;

import java.util.List;

import org.amazon.shopping.dao.ProductDao;
import org.amazon.shopping.model.Product;
import org.amazon.shopping.model.ProductStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product/")
public class ProductListController {
	 	@Autowired
	    private ProductDao productDao;
	    
	    @RequestMapping("/listingproduct")
	    public String outputproduct(ModelMap map, String category) {
	        List<Product> products = productDao.getProductsByCategory(category);	        
	        map.addAttribute("listingproduct", products);
	        return "outputproduct";
	    }
}
