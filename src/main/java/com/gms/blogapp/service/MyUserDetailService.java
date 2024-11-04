package com.gms.blogapp.service;

import com.gms.blogapp.Repository.UserRepository;
import com.gms.blogapp.entity.User;
import com.gms.blogapp.entity.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository.findByUserName(username);
        if(user==null){
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User not found!");
        }
        return new UserPrincipal(user);
    }
}
