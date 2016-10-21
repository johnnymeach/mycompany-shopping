/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.view;

import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Part;

import org.amazon.shopping.dao.ProductUploadDao;
import org.amazon.shopping.dao.VendorLogDao;
import org.amazon.shopping.dao.impl.ProductUploadDaoImpl;
import org.amazon.shopping.dao.impl.VendorLogDaoImpl;
import org.amazon.shopping.model.VendorLog;

/**
 *
 * @author Sokly
 */
@ManagedBean
@SessionScoped
public class Product implements Serializable {
    
    private Part file;
    private String prodName;
    private double price;
    private String description;
    private String brand;
    private String category;
    private String picture;
    private int vendorId;
    private String vendor;
    private int quantity;
    private String status;
    private long imageSize;
    private long availableSpace;
    //@ManagedProperty(value="#{login.username}")
    //private String username;
    private ProductUploadDao productUploadDao;
    private VendorLogDao vendordao;

    public long getImageSize() {
        return imageSize;
    }

    public void setImageSize(long imageSize) {
        this.imageSize = imageSize;
    }

    public long getAvailableSpace() {
        return availableSpace;
    }

    public void setAvailableSpace(long availableSpace) {
        this.availableSpace = availableSpace;
    }   
        
    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
    
    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }   
    
    
    public String uploadProduct() throws IOException {
               
        productUploadDao = new ProductUploadDaoImpl();
        vendordao = new VendorLogDaoImpl();
        VendorLog vlog = vendordao.getCurrentVendor();
        String vendor_name = vlog.getVendor_name();
        // Email Notification
        long size = file.getSize();
        long sizeMB = size/1000000;
        this.setImageSize(sizeMB);        
        long space = vendordao.adjustUsedSpace(vendor_name, sizeMB);
        long remainingSize = 50000 - space;
        this.setAvailableSpace(remainingSize);
        if (space > 50000) {
        this.setStatus("D");    
        final String username = "meachsokly@gmail.com";
        final String password = "12345";

        Properties props = new Properties();       
                      
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.transport.protocol", "smtp");    
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.socketFactory.port", "465");
         Session session = Session.getInstance(props,
                  new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                  });


        try {
            Transport transport=session.getTransport();
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("meachsokly@gmail.com"));//formBean.getString("fromEmail")
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("afsar.ahmd.babu@gmail.com"));
            message.setSubject("You have exceeded maximum allocated space of 50 GB");//formBean.getString(
            message.setText("Please consider to buy more space");
            transport.connect();
            transport.send(message, InternetAddress.parse("meachsokly@gmail.com"));//(message);

            //System.out.println("Done");

        } catch (MessagingException e) {
            System.out.println("e="+e);
            e.printStackTrace();
            throw new RuntimeException(e);

            }
        } else {
            this.setStatus("A");
            // end mail
            //System.out.println("\n\n"+actualSize+"\n\n");
        // End Email Notification
        file.write("resources\\images\\product-images"+getFileName(file));
        this.setPicture("resources\\images\\product-images\\"+getFileName(file));
        org.amazon.shopping.model.Product p = new org.amazon.shopping.model.Product();
        p.setImageUrl(picture);
        p.setBrand(brand);
        p.setCategory(category);
        p.setPrice(price);
        p.setProductDetails(description);
        p.setProductName(prodName);
        p.setQuantity(quantity);
        p.setVendorName(vendor_name);
        productUploadDao.uploadProduct(p);
        }
        return "productUploadSuccess";
    }
    
    public String getFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
    
}

