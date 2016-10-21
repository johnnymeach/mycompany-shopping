/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.ColumnTransformer;

/**
 *
 * @author Nizomiddin
 */
@Entity
@Table(name="customer_card")
public class CustomerCard {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = true)
    private Customer customer;
    @Transient
    private String cardNo;
    @Column(name="card_type")
    private String cardType;
    @Column(name="full_name")
    private String fullName;
    @Transient
    private String cardCode;
    @Transient
    private String cardExpiry;
    private boolean enabled;

    @Column(columnDefinition= "LONGBLOB", name="card_no") 
    @ColumnTransformer(
        read="AES_DECRYPT(card_no, 'mum-online-shop')", 
        write="AES_ENCRYPT(?, 'mum-online-shop')")
    byte[]  cardNoByte;
    
    @Column(columnDefinition= "LONGBLOB", name="card_code") 
    @ColumnTransformer(
        read="AES_DECRYPT(card_code, 'mum-online-shop')", 
        write="AES_ENCRYPT(?, 'mum-online-shop')")
    byte[]  cardCodeByte;

    @Column(columnDefinition= "LONGBLOB", name="card_expiry") 
    @ColumnTransformer(
        read="AES_DECRYPT(card_expiry, 'mum-online-shop')", 
        write="AES_ENCRYPT(?, 'mum-online-shop')")
    byte[]  cardExpiryByte;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getCardExpiry() {
        return cardExpiry;
    }

    public void setCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public byte[] getCardNoByte() {
        return cardNoByte;
    }

    public void setCardNoByte(byte[] cardNoByte) {
        this.cardNoByte = cardNoByte;
    }

    public byte[] getCardCodeByte() {
        return cardCodeByte;
    }

    public void setCardCodeByte(byte[] cardCodeByte) {
        this.cardCodeByte = cardCodeByte;
    }

    public byte[] getCardExpiryByte() {
        return cardExpiryByte;
    }

    public void setCardExpiryByte(byte[] cardExpiryByte) {
        this.cardExpiryByte = cardExpiryByte;
    }
    
    
    
}
