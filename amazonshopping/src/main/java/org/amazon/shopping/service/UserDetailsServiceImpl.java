/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amazon.shopping.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.amazon.shopping.dao.UserDao;
import org.amazon.shopping.model.UserRoles;
import org.amazon.shopping.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sokly
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Transactional
//    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
    	org.amazon.shopping.model.Users user = userDao.getUserByUsername(string);
	List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
	return new User(user.getUsername(), user.getPassword(), 
			user.isEnabled(), true, true, true, authorities);
    }
    
    private List<GrantedAuthority> buildUserAuthority(Set<UserRoles> userRoles) {
	Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
	for (UserRoles userRole : userRoles) {
		setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
	}
	List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
	return Result;
    }
}
