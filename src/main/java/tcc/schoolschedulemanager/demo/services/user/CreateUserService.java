package tcc.schoolschedulemanager.demo.services.user;

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

//service para criar um usuário
@Configuration
@Service
public class CreateUserService {

  //injeção de dependência dos repositórios necessários
  @Autowired
  private UserRepository userRepository;

  //injeção de dependência dos repositórios necessários
  @Autowired
  private RoleRepository roleRepository;

  //método para encriptar a senha do usuário com o BCrypt
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
  //método para criar um usuário
  public UserModel register(UserModel user) {
    
    //verifica se o usuário já existe pelo número de matrícula
    Optional<UserModel> userExists = userRepository.findByRegistrationNumber(user.getRegistrationNumber());
    if(userExists.isPresent()) {
      throw new RuntimeException("User already exists");
    }

    //cria um novo usuário com a senha encriptada
    UserModel userToSave = new UserModel();
    userToSave.setName(user.getName());
    userToSave.setRegistrationNumber(user.getRegistrationNumber());
    userToSave.setPassword(passwordEncoder().encode(user.getPassword()));

    //verifica se a role existe por questões de boas práticas
    Optional<RoleModel> role = roleRepository.findByName(RoleName.ROLE_USER);
    if(!role.isPresent()){
      throw new RuntimeException("Role not found");
    }
    //adiciona a role ao usuário padrão (ROLE_USER)
        RoleModel defaultRole = role.get();
        userToSave.addRole(defaultRole); 
        System.out.println("Role added");
    
    return userRepository.save(userToSave);


  }
}
