package tcc.schoolschedulemanager.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tcc.schoolschedulemanager.demo.models.UserModel;
import tcc.schoolschedulemanager.demo.services.CreateUserService;

@RestController
@RequestMapping("/api/register")
@CrossOrigin(origins = "*")
public class UserController  {
    
    private final CreateUserService createUserService;

    @Autowired 
    public UserController(CreateUserService createUserService) {
        this.createUserService = createUserService;
    }

    @PostMapping
    public UserModel register(@RequestBody UserModel user) {
        return createUserService.register(user);
    }
}
