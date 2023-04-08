package tcc.schoolschedulemanager.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tcc.schoolschedulemanager.demo.models.RoleModel;
import tcc.schoolschedulemanager.demo.models.UserModel;
import tcc.schoolschedulemanager.demo.repositories.RoleRepository;
import tcc.schoolschedulemanager.demo.repositories.UserRepository;
import tcc.schoolschedulemanager.enums.RoleName;

@Configuration
@Service
public class CreateUserService {


  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
  public UserModel register(UserModel user) {
    
    Optional<UserModel> userExists = userRepository.findByRegistrationNumber(user.getRegistrationNumber());
    if(userExists.isPresent()) {
      throw new RuntimeException("User already exists");
    }
    UserModel userToSave = new UserModel();
    userToSave.setName(user.getName());
    userToSave.setRegistrationNumber(user.getRegistrationNumber());
    userToSave.setPassword(passwordEncoder().encode(user.getPassword()));

    Optional<RoleModel> role = roleRepository.findByName(RoleName.ROLE_USER);
    if(role.isPresent()){
        RoleModel defaultRole = role.get();
        userToSave.addRole(defaultRole); 
        System.out.println("Role added");
    }
    return userRepository.save(userToSave);


  }
}
