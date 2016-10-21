/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.dao;

import java.util.List;

import org.amazon.shopping.model.ROC;

/**
 *
 * @author Sokly
 */
public interface ROCDao {
    void saveROC(ROC roc);
    List<ROC> getROCByName(String name);
}
