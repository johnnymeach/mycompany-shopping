/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.dao;

import org.amazon.shopping.model.BankCard;

/**
 *
 * @author Nizomiddin
 */
public interface BankDao {
    BankCard getBankCard(String cardNo, String cardCode, String cardExpiry, String fullName);
    String updateBankCard(BankCard card);
}
