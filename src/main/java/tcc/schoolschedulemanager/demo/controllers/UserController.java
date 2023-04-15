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
import tcc.schoolschedulemanager.demo.services.AuthUserService;
import tcc.schoolschedulemanager.demo.services.CreateUserService;


@RestController
@RequestMapping("/api/user")
public class UserController  {
    
    private final CreateUserService createUserService;
    
   

    private final AuthUserService authUserService;

    public UserController(CreateUserService createUserService, AuthUserService authUserService) {
        this.createUserService = createUserService;
        this.authUserService = authUserService;
    }
    

    @PostMapping("/sing-up")
    public UserModel register(@RequestBody UserModel user) {
        return createUserService.register(user);
    }

    @PostMapping("/sing-in")
    public ResponseEntity<?> login(@RequestBody UserModel user) {
       return  authUserService.AuthUserService(user);

    }

}
