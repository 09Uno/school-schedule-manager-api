package tcc.schoolschedulemanager.demo.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import tcc.schoolschedulemanager.demo.config.security.JwtUtil;
import tcc.schoolschedulemanager.demo.models.UserModel;

@Service
public class AuthUserService {
    
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil JwtUtil;
     

    public ResponseEntity<?> AuthUserService(UserModel user) {

        org.springframework.security.core.Authentication authentication = 
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getRegistrationNumber(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User userAuthed  = (User) authentication.getPrincipal();
        String token = JwtUtil.generateToken(userAuthed);

        return ResponseEntity.ok(token);
    }


}
