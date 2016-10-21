/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Nizomiddin
 */
@Entity
public class Users {
    @Id
    private String username;
    private String password;
    private boolean enabled;
    
    @OneToMany(fetch = FetchType.LAZY, 
            cascade = {CascadeType.ALL}, 
            mappedBy = "user")
    private Set<UserRoles> userRole = new HashSet<UserRoles>(0);

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRoles> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRoles> userRole) {
        this.userRole = userRole;
    }

}
