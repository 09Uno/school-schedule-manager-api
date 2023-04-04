package tcc.schoolschedulemanager.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tcc.schoolschedulemanager.demo.models.UserModel;
import tcc.schoolschedulemanager.demo.models.repository.UserRepository;

@RestController
@RequestMapping("/api/register")
@CrossOrigin(origins = "*")
public class UserController {
    

    @Autowired
    private UserRepository registerRepository;

    @PostMapping
    public UserModel register(@RequestBody UserModel user) {
        UserModel userRegister = new UserModel(user.getName(), user.getRegistrationNumber(), user.getPassword());
        registerRepository.save(userRegister);
        return user;
    }
}
