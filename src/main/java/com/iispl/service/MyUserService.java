package com.iispl.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.iispl.dao.UserDAO;

public class MyUserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.iispl.model.User user = UserDAO.getUserByUsername(username);
        
        
        if (user == null) {
            System.out.println("User not found: " + username);
            throw new UsernameNotFoundException("User not found");
        }

        System.out.println("User Data\n" + user);

        // Use role from DB
        String role = null;
        if (role == null || role.isEmpty()) {
            role = "ROLE_USER";
        }

        return new User(
            user.getEmail(),
            user.getPassword(),
            toGrantedAuthorities(new String[] { role })
        );
    }

    private Collection<? extends GrantedAuthority> toGrantedAuthorities(String[] roles) {
        ArrayList<GrantedAuthority> authorities = new ArrayList<>(roles.length);
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
