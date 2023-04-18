package tcc.schoolschedulemanager.demo.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tcc.schoolschedulemanager.demo.models.UserModel;
import tcc.schoolschedulemanager.demo.requests.user.UserRoleRequest;
import tcc.schoolschedulemanager.demo.services.user.AddRoleService;
import tcc.schoolschedulemanager.demo.services.user.AuthUserService;
import tcc.schoolschedulemanager.demo.services.user.CreateUserService;


@RestController
@RequestMapping("/api/user")
public class UserController  {
    
    private final CreateUserService createUserService;
    private final AuthUserService authUserService;
    private final AddRoleService addRoleService;

    public UserController(CreateUserService createUserService, AuthUserService authUserService, AddRoleService addRoleService) {
        this.createUserService = createUserService;
        this.authUserService = authUserService;
        this.addRoleService = addRoleService;
    }
    
    @PostMapping("/sing-up")
    public UserModel register(@RequestBody UserModel user) {
        return createUserService.register(user);
    }

    @PostMapping("/sing-in")
    public ResponseEntity<?> login(@RequestBody UserModel user) {
       return  authUserService.AuthUserService(user);

    }
    
    @PutMapping("/add-role")
    public UserModel addRole(@RequestBody UserRoleRequest request) {
        return addRoleService.addRole(request.getUserReq(), request.getRoleReq());
    }

    //getAll
    //getById
    //getByName
    //getByRegistrationNumber
    //DeleteById


}
