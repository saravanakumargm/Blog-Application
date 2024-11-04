package com.gms.blogapp.service;

import com.gms.blogapp.Repository.UserRepository;
import com.gms.blogapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JWTService jwtService;
    public ResponseEntity<String> login(User user) {
        Authentication authentication = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        user.getUserName(),user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUserName());
        }
        return new ResponseEntity<>("Failed!",HttpStatus.BAD_REQUEST);

    }


    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public ResponseEntity<User> register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return new ResponseEntity<>(userRepository.save(user),HttpStatus.OK);
    }

    public User getAllBookmarks(int id) {
        return userRepository.findById(id).get();
    }
//    @Autowired
//    private Authentication = SecurityContextHolder.getContext().getAuthentication();
    public ResponseEntity<String> changePassword(User user){
//        if(authentication.isAuthenticated() && authentication.getCredentials()!=user.getPassword()){
//            user.setPassword(user.getPassword());
//        }
//        userRepository.save(user);
        return new ResponseEntity<>("Password changed",HttpStatus.OK);
    }
}
