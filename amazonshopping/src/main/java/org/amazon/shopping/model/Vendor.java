/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author tonyliu
 */
@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int vendorId;
    private long allocated_space;
    private String reg_num;
    private long used_space;
    private String vendor_name;
    private String cc_num;
    private String city;
    private String password;
    private String state_name;
    private String email;
    private boolean status;
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getVendor_name() {
        return vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public long getAllocated_space() {
        return allocated_space;
    }

    public void setAllocated_space(long allocated_space) {
        this.allocated_space = allocated_space;
    }

    public String getReg_num() {
        return reg_num;
    }

    public void setReg_num(String reg_num) {
        this.reg_num = reg_num;
    }

    public long getUsed_space() {
        return used_space;
    }

    public void setUsed_space(long used_space) {
        this.used_space = used_space;
    }

    public String getCc_num() {
        return cc_num;
    }

    public void setCc_num(String cc_num) {
        this.cc_num = cc_num;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
