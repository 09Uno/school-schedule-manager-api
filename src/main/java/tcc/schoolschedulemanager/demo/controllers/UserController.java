package tcc.schoolschedulemanager.demo.controllers;


import java.security.Security;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tcc.schoolschedulemanager.demo.config.security.JwtUtil;
import tcc.schoolschedulemanager.demo.config.security.UserDetailSecurity;
import tcc.schoolschedulemanager.demo.models.UserModel;
import tcc.schoolschedulemanager.demo.services.CreateUserService;


@RestController
@RequestMapping("/api/user")
public class UserController  {
    
    private final CreateUserService createUserService;
    
    private final UserDetailSecurity userDetailSecurity;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    JwtUtil JwtUtil;
   
    public UserController(CreateUserService createUserService, UserDetailSecurity userDetailSecurity) {
        this.createUserService = createUserService;
        this.userDetailSecurity = userDetailSecurity;
    }


    @PostMapping
    @RequestMapping("/singup")
    public UserModel register(@RequestBody UserModel user) {
        return createUserService.register(user);
    }

    @PostMapping
    @RequestMapping("/singin")
    public ResponseEntity<?> login(@RequestBody UserModel user) {
        org.springframework.security.core.Authentication authentication = 
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getRegistrationNumber(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User userAuthed  = (User) authentication.getPrincipal();
        String token = JwtUtil.generateToken(userAuthed);
        return ResponseEntity.ok(token);

    }
}
