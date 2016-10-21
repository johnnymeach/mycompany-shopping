/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;
import org.hibernate.annotations.ColumnTransformer;

/**
 *
 * @author Nizomiddin
 */
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email_add")
    private String email;
    @Transient
    private String password;
    private Date dob;
    @Column(name="create_time")
    private Date createTime;
    
    @OneToMany(fetch = FetchType.EAGER, 
            mappedBy = "customer")
    @OrderBy("id DESC")
    private Set<CustomerAddress> addressList = new HashSet<CustomerAddress>(0);

    @OneToMany(fetch = FetchType.EAGER, 
            mappedBy = "customer")
    @OrderBy("id DESC")
    private Set<CustomerCard> cardList = new HashSet<CustomerCard>(0);

    @OneToMany(fetch = FetchType.EAGER, 
            mappedBy = "customer")
    @OrderBy("id DESC")
    private Set<Transaction> tranList = new HashSet<Transaction>(0);

    @Transient
    private CustomerAddress address;
    @Transient
    private CustomerCard card;
    @Transient
    private String path;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public CustomerAddress getAddress() {
        return address;
    }

    public void setAddress(CustomerAddress address) {
        this.address = address;
    }

    public CustomerCard getCard() {
        return card;
    }

    public void setCard(CustomerCard card) {
        this.card = card;
    }

    public Set<CustomerAddress> getAddressList() {
        return addressList;
    }

    public void setAddressList(Set<CustomerAddress> addressList) {
        this.addressList = addressList;
    }

    public Set<CustomerCard> getCardList() {
        return cardList;
    }

    public void setCardList(Set<CustomerCard> cardList) {
        this.cardList = cardList;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Set<Transaction> getTranList() {
        return tranList;
    }

    public void setTranList(Set<Transaction> tranList) {
        this.tranList = tranList;
    }
    
    
    
}
