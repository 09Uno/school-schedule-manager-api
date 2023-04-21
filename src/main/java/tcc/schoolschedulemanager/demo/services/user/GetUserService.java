package tcc.schoolschedulemanager.demo.services.user;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tcc.schoolschedulemanager.demo.dto.UserDTO;
import tcc.schoolschedulemanager.demo.models.UserModel;
import tcc.schoolschedulemanager.demo.repositories.UserRepository;

@Service
public class GetUserService {

  @Autowired
  private UserRepository userRepository;

  public Page<UserDTO> getAll(Pageable pageable) {
    return userRepository.findAllUsers(pageable);
  }

  public UserModel getById(UUID id){
    try {
        Optional<UserModel> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new IllegalArgumentException("User not found");
        }
        UserModel response = new UserModel(user.get().getId(), user.get().getName(), user.get().getRegistrationNumber(), user.get().getRoles());
        return response;
    
    } catch (RuntimeException e) {
        throw new RuntimeException("Error trying to get this user by id" + e);
    }
   
  }


}
