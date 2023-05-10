package tcc.schoolschedulemanager.demo.controllers;


import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tcc.schoolschedulemanager.demo.dto.UserDTO;
import tcc.schoolschedulemanager.demo.models.UserModel;
import tcc.schoolschedulemanager.demo.requests.UserRoleRequest;
import tcc.schoolschedulemanager.demo.services.user.AddRoleService;
import tcc.schoolschedulemanager.demo.services.user.AuthUserService;
import tcc.schoolschedulemanager.demo.services.user.CreateUserService;
import tcc.schoolschedulemanager.demo.services.user.GetUserService;

//Controller para os usuários
@RestController
@RequestMapping("/api/user")
public class UserController  {
    
    private final CreateUserService createUserService;
    private final AuthUserService authUserService;
    private final AddRoleService addRoleService;
    private final GetUserService getUserService;
    

    public UserController(CreateUserService createUserService, AuthUserService authUserService, AddRoleService addRoleService, GetUserService getUserService) {
        this.createUserService = createUserService;
        this.authUserService = authUserService;
        this.addRoleService = addRoleService;
        this.getUserService = getUserService;
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

    @GetMapping("/get-all")
    public ResponseEntity<Page<UserDTO>> getAll(

    @RequestParam(value = "page", defaultValue = "0") int page,
    @RequestParam(value = "size", defaultValue = "10") int size,
    @RequestParam(value = "sort", defaultValue = "name,asc") String[] sort
    ){

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return ResponseEntity.ok(getUserService.getAll(pageable));
    }

    //getById
    @GetMapping("/get-by-id")
    public ResponseEntity<UserDTO> getById(@RequestParam UUID id){
        return ResponseEntity.ok(getUserService.getById(id));
    }

    //getByName
    @GetMapping("/get-by-name")
    public ResponseEntity<Page<UserDTO>> getByName(@RequestBody String name, 
    @RequestParam(value = "page", defaultValue = "0") int page,
    @RequestParam(value = "size", defaultValue = "10") int size,
    @RequestParam(value = "sort", defaultValue = "name,asc") String[] sort
    ){
            Pageable pageable = PageRequest.of(0, 10, Sort.by("name"));
            return ResponseEntity.ok(getUserService.getByName(name, pageable));
    }

    //editById
    //getByRegistrationNumber
    //DeleteById
}
