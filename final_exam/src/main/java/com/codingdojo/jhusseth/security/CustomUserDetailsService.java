package com.codingdojo.jhusseth.security;


import com.codingdojo.jhusseth.domain.dto.UserDetailsDTO;
import com.codingdojo.jhusseth.domain.model.User;
import com.codingdojo.jhusseth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findUserByEmail(username);
        if (user != null) {
            Set<GrantedAuthority> roles = new HashSet<>();
            roles.add(new SimpleGrantedAuthority("USER"));
            return new UserDetailsDTO(
                    user.getId(),
                    user.getUsername(),
                    user.getPassword(),
                    roles
            );
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
    }
}