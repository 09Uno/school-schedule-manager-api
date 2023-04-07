package tcc.schoolschedulemanager.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tcc.schoolschedulemanager.demo.models.UserModel;
import tcc.schoolschedulemanager.demo.repository.UserRepository;

@Service
public class CreateUserService {

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  private final UserRepository userRepository;

  @Autowired
  public CreateUserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserModel register(UserModel user) {
    UserModel userRegister = new UserModel(
      user.getName(),
      user.getRegistrationNumber(),
      passwordEncoder().encode(user.getPassword()),
      user.getRole()
    );
    userRepository.save(userRegister);
    return userRegister;
  }
}
