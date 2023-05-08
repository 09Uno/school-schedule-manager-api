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

//service para autenticação de usuários
@Service
public class AuthUserService {
    
    //injeção de dependência do gerenciador de autenticação
    @Autowired
    AuthenticationManager authenticationManager;
    
    //injeção de dependência do utilitário de geração de token
    @Autowired
    JwtUtil JwtUtil;
     
    //método para autenticar um usuário
    public ResponseEntity<?> AuthUserService(UserModel user) {

        //autentica o usuário
        org.springframework.security.core.Authentication authentication = 
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getRegistrationNumber(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User userAuthed  = (User) authentication.getPrincipal();
        String token = JwtUtil.generateToken(userAuthed);

        //retorna o token gerado   
        return ResponseEntity.ok(token);
    }


}
